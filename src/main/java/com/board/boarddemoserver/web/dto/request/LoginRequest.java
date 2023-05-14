package com.board.boarddemoserver.web.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Login 요청 Command
 *
 * TODO : Password 처리
 *
 * @author Dave Shin
 */

@Getter
public class LoginRequest {
    @NotBlank
    String name;
    @NotBlank
    // TODO : pattern 정책 적용
    // @Pattern()
    String password;
}
