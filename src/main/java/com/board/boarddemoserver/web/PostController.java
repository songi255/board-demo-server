package com.board.boarddemoserver.web;

import com.board.boarddemoserver.service.PostService;
import com.board.boarddemoserver.web.command.post.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public List<PostGetListResponse> getAllPost(){
        return postService.findAll();
    }

    @GetMapping("/{postId}")
    public PostGetResponse getPostDetail(@PathVariable Long postId){
        return null;
    }

    @PostMapping("/{postId}")
    public ResponseEntity<PostPostResponse> post(@PathVariable Long postId){
        return null;
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostEditResponse> edit(@PathVariable Long postId){
        return null;
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDeleteResponse> delete(@PathVariable Long postId){
        return null;
    }

}
