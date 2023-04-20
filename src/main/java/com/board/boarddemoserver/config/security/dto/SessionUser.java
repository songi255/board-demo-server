package com.board.boarddemoserver.config.security.dto;

import com.board.boarddemoserver.domain.user.Role;
import lombok.Getter;

@Getter
public class SessionUser {
    private String nickname;
    private Role role;

    public SessionUser(String nickname, Role role) {
        this.nickname = nickname;
        this.role = role;
    }
}
