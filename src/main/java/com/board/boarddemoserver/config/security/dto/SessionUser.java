package com.board.boarddemoserver.config.security.dto;

import com.board.boarddemoserver.domain.user.Role;
import com.board.boarddemoserver.domain.user.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Login 성공 시 Session 에 저장할 User 정보를 담은 클래스
 * Session 에 저장하기 위해 Serializable 구현
 *
 * 저장 항목
 *  - nickname
 *  - Role
 *
 * @author Dave Shin
 */

@Getter
@NoArgsConstructor
public class SessionUser implements Serializable{
    private String nickname;
    private String role;

    public SessionUser(UserInfo userInfo){
        this.nickname = userInfo.getNickname();
        this.role = userInfo.getRole();
    }

    @Builder
    public SessionUser(String nickname, String role) {
        this.nickname = nickname;
        this.role = role;
    }
}
