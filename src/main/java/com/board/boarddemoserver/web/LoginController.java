package com.board.boarddemoserver.web;

import com.board.boarddemoserver.config.security.dto.SessionUser;
import com.board.boarddemoserver.domain.user.UserInfo;
import com.board.boarddemoserver.domain.user.UserInfoRepository;
import com.board.boarddemoserver.domain.user.UserNotFoundException;
import com.board.boarddemoserver.web.dto.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Login, Logout 처리 담당 Controller
 *
 * @author Dave Shin
 */

@RequiredArgsConstructor
@RestController
public class LoginController {
    private final UserInfoRepository userInfoRepository;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody @Valid LoginRequest request, HttpSession session) throws Exception{
        UserInfo userInfo = userInfoRepository.findByName(request.getName())
                .orElseThrow(UserNotFoundException::new);

        if (userInfo.getPassword().equals(request.getPassword())){
            session.setAttribute("user", new SessionUser(userInfo));
            return ResponseEntity.accepted().build();
        } else {
            throw new AuthenticationException("비밀번호가 일치하지 않습니다.");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session){
        session.invalidate();
        return ResponseEntity.ok().build();
    }
}
