package com.board.boarddemoserver.web.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Post 수정 Request
 *
 * @author Dave Shin
 */

@Getter
public class PostEditRequest {
    @NotBlank
    private String title;
    @Size(max = 1000) // content 사이즈 1000자 제한
    private String content;

}
