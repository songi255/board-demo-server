package com.board.boarddemoserver.web;

import com.board.boarddemoserver.domain.user.UserInfo;
import com.board.boarddemoserver.web.command.post.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<UserInfo> login(@RequestParam LoginRequest request, HttpSession session){
        // 1. id로 User entity 조회
        // 2. password 대조.
        // 3. 성공시 session 에 setattribute 로 ok(User) 데이터를 넣음 -> sessionUser 로 바꾸자.(영속성)
        // 4. 실패 시 status 에 UnAutho ㅇㅇ

        return null;
    }


    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session){
        session.invalidate();
        return ResponseEntity.ok().build();
    }
}
