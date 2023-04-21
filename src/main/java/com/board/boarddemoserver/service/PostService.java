package com.board.boarddemoserver.service;

import com.board.boarddemoserver.domain.post.Post;
import com.board.boarddemoserver.domain.post.PostNotFoundException;
import com.board.boarddemoserver.domain.post.PostsRepository;
import com.board.boarddemoserver.domain.user.UserInfo;
import com.board.boarddemoserver.domain.user.UserInfoRepository;
import com.board.boarddemoserver.domain.user.UserNotFoundException;
import com.board.boarddemoserver.web.command.request.*;
import com.board.boarddemoserver.web.command.response.PostEditResponse;
import com.board.boarddemoserver.web.command.response.PostGetListResponse;
import com.board.boarddemoserver.web.command.response.PostGetResponse;
import com.board.boarddemoserver.web.command.response.PostPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Post Entity 조작, 매핑 및 Transaction 관리 Service
 *
 * @author Dave Shin
 */

@RequiredArgsConstructor
@Service
public class PostService {
    private final UserInfoRepository userInfoRepository;
    private final PostsRepository postsRepository;

    // 게시글 List 반환
    @Transactional(readOnly = true)
    public List<PostGetListResponse> findAll(){
        return postsRepository.findAll().stream()
                .map(PostGetListResponse::new)
                .collect(Collectors.toList());
    }

    // 게시글 열람
    @Transactional(readOnly = true)
    public PostGetResponse findById(Long id){
        Post post = postsRepository.findById(id)
                        .orElseThrow(PostNotFoundException::new);

        return new PostGetResponse(post);
    }

    // 게시글 작성
    @Transactional
    public PostPostResponse post(PostPostRequest request){
        UserInfo userInfo = userInfoRepository.findByNickname(request.getAuthor())
                .orElseThrow(UserNotFoundException::new);

        Post post = postsRepository.save(
                Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(userInfo)
                .build()
        );

        return new PostPostResponse(post);
    }

    // 게시글 수정
    @Transactional
    public PostEditResponse edit(Long id, PostEditRequest request){
        Post post = postsRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);

        post.update(request.getTitle(), request.getContent());

        return new PostEditResponse(post);
    }

    // 게시글 삭제
    @Transactional
    public void delete(Long id){
        Post post = postsRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);

        postsRepository.delete(post);
    }

}
