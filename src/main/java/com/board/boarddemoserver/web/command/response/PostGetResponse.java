package com.board.boarddemoserver.web.command.response;

import com.board.boarddemoserver.domain.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 게시글 열람에 대한 응답객체
 *
 * TODO : Comment, 좋아요, 싫어요 정보 필요
 * 
 * @author Dave Shin
 */

@Getter
public class PostGetResponse {
    private Long no;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public PostGetResponse(Post post){
        this.no = post.getNo();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor().getNickname();
        this.createdTime = post.getCreatedTime();
        this.modifiedTime = post.getModifiedTime();
    }
}
