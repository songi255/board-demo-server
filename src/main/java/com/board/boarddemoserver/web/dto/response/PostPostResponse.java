package com.board.boarddemoserver.web.dto.response;

import com.board.boarddemoserver.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 게시글 작성 성공 시 응답 객체
 *
 * 응답항목 : 작성된 게시글 정보
 *
 * @author Dave Shin
 */

@Getter
@NoArgsConstructor
@Setter
public class PostPostResponse {
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdTime;

    @Builder
    public PostPostResponse(String title, String content, String author, LocalDateTime createdTime) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdTime = createdTime;
    }

    public PostPostResponse(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor().getNickname();
        this.createdTime = post.getCreatedTime();
    }
}
