package com.board.boarddemoserver.web.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * 게시글 작성 요청 Command
 *
 * 작성자 정보(author)는 Session 에서 처리한다.
 *
 * @author Dave Shin
 */

@Getter
@NoArgsConstructor
@Setter
public class PostPostRequest {
    @NotBlank
    private String title;
    @Size(max = 1000) // 본문 최대 1000자 제한
    private String content;
    @Null // author 는 Session 에서 주입
    private String author;

    @Builder
    public PostPostRequest(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
