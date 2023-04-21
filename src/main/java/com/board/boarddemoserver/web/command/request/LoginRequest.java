package com.board.boarddemoserver.web.command.request;

import lombok.Getter;

/**
 * Login 요청 Command
 *
 * TODO : Password 처리
 *
 * @author Dave Shin
 */

@Getter
public class LoginRequest {
    String name;
    String password;
}
