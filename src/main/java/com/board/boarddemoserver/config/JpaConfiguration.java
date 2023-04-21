package com.board.boarddemoserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * JPA 설정클래스
 * 
 * 현재 설정값
 *  - JPA Auditing 기능 활성화
 * 
 * @author Dave Shin
 */

@EnableJpaAuditing
@Configuration
public class JpaConfiguration {
}
