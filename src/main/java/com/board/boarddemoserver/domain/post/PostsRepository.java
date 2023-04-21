package com.board.boarddemoserver.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Post 의 JPA Repository
 *
 * @author Dave Shin
 */

public interface PostsRepository extends JpaRepository<Post, Long> {
}
