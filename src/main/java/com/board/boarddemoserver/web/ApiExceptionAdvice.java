package com.board.boarddemoserver.web;

import com.board.boarddemoserver.domain.post.PostNotFoundException;
import com.board.boarddemoserver.domain.user.UserNotFoundException;
import com.board.boarddemoserver.web.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 사용자 정의 Exception 에 관한 공통 처러
 *
 * @author Dave Shin
 */

@RestControllerAdvice
public class ApiExceptionAdvice {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePostNotFound(){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("post not found"));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("user not found"));
    }
}
