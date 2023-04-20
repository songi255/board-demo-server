package com.board.boarddemoserver.service;

import com.board.boarddemoserver.domain.post.Post;
import com.board.boarddemoserver.domain.post.PostsRepository;
import com.board.boarddemoserver.web.command.post.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;

    // TODO advice 추가

    @Transactional(readOnly = true)
    public List<PostGetListResponse> findAll(){
        return postsRepository.findAll().stream()
                .map(PostGetListResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostGetResponse findById(Long id){
        Post post = postsRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다."));

        return new PostGetResponse(post);
    }

    @Transactional
    public PostPostResponse post(PostPostRequest request){
        Post post = postsRepository.save(request.toEntity());

        // FIXME
        return new PostPostResponse();
    }

    @Transactional
    public PostEditResponse edit(Long id, PostEditRequest request){
        Post post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        // 특화 메서드.
        //post.update();

        // build
        return new PostEditResponse();
    }

    @Transactional
    public void delete(Long id){
        Post post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        postsRepository.delete(post);
    }

}
