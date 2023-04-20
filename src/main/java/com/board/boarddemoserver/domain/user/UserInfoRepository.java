package com.board.boarddemoserver.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByNickname(String nickname);
}
