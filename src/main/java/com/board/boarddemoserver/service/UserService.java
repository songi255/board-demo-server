package com.board.boarddemoserver.service;

import com.board.boarddemoserver.domain.user.UserInfoRepository;
import com.board.boarddemoserver.web.command.response.UserListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserInfoRepository userInfoRepository;

    //login

    //logout

    // need pagenation
    @GetMapping("")
    public List<UserListResponse> getAllUserList(){
        //userInfoRepository.findAll().stream()
                //.map();

        return null;
    }

    // getnickname // id


}
