package com.board.boarddemoserver.web.dto.response;

import com.board.boarddemoserver.domain.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostEditResponse {
    private Long no;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedTime;

    public PostEditResponse(Post post) {
        this.no = post.getNo();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor().getNickname();
        this.modifiedTime = post.getModifiedTime();
    }
}
