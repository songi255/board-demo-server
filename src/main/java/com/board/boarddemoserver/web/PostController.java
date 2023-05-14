package com.board.boarddemoserver.web;

import com.board.boarddemoserver.config.security.LoginUser;
import com.board.boarddemoserver.config.security.dto.SessionUser;
import com.board.boarddemoserver.service.PostService;
import com.board.boarddemoserver.web.dto.request.*;
import com.board.boarddemoserver.web.dto.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Post 에 관한 응답을 처리하는 Controller
 *
 * @author Dave Shin
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    // 게시글 목록 확인
    // TODO : @RequestParam 을 통한 sort 구현
    @GetMapping("")
    public List<PostGetListResponse> getAllPost(){
        return postService.findAll();
    }

    // 게시글 열람
    @GetMapping("/{postId}")
    public PostGetResponse getPostDetail(@PathVariable Long postId){
        return postService.findById(postId);
    }

    // TODO : 본인확인 정보 일원화 고려
    // 게시글 작성
    //@PreAuthorize("hasRole(ROLE_USER)")
    @PostMapping("")
    public ResponseEntity<PostPostResponse> post(@RequestBody @Valid PostPostRequest request,
                                                 @LoginUser SessionUser sessionUser){
        request.setAuthor(sessionUser.getNickname());
        PostPostResponse response = postService.post(request);

        return ResponseEntity.ok().body(response);
    }

    // TODO : 본인 맞는지 확인 필요
    // 게시글 수정
    //@PreAuthorize()
    @PutMapping("/{postId}")
    public ResponseEntity<PostEditResponse> edit(@PathVariable Long postId,
                                                 @RequestBody @Valid PostEditRequest request){
        postService.edit(postId, request);

        return null;
    }

    // TODO : 본인 맞는지 확인 필요
    // 게시글 삭제
    // @PreAuthorize()
    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDeleteResponse> delete(@PathVariable Long postId){
        postService.delete(postId);

        return null;
    }

}
