package com.board.boarddemoserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 보안 설정 클래스
 *
 * 현재 설정값
 *  - WebFilter 적용
 *
 * @author Dave Shin
 */

@RequiredArgsConstructor
@EnableMethodSecurity
@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain customSecurityPolicy(HttpSecurity http) throws Exception{
        return http
                // h2-console 접근을 위한 보안설정
                .csrf().disable()
                .headers().frameOptions().disable()
                // FIXME : 임시로 http 로 request 보낼 수 있게 설정. https 도입 후 제거 필요.
                .and().httpBasic()
                // form Login 해제
                .and().formLogin().disable()
                // method 수준 보안 적용을 위해 경로인증 해제
                .authorizeRequests()
                .anyRequest().permitAll()
                .and().build();
    }
}
