package com.board.boarddemoserver.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * User 별 보안 권한 지정용 Enum Class
 *
 * @author Dave Shin
 */

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_QUEST"),
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String key;
}
