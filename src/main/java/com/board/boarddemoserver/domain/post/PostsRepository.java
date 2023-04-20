package com.board.boarddemoserver.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {
}
