package com.board.boarddemoserver.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Error 응답에 반환할 내용을 담은 dto
 *
 * TODO : 여러 예외에서 공통으로 쓰일 수 있게 code 등의 내용 추가
 *
 * @author Dave Shin
 */

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private String message;

    @Builder
    public ErrorResponse(String message) {
        this.message = message;
    }
}
