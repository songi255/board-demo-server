package com.board.boarddemoserver.web.command.post;

import com.board.boarddemoserver.domain.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostGetListResponse {
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdTime;

    public PostGetListResponse(Post post){
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor().getNickname();
        this.createdTime = post.getCreatedTime();
    }
}
