package com.board.boarddemoserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


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
                // method 수준 보안 적용을 위해 경로인증 해제
                .and().authorizeRequests()
                .anyRequest().permitAll()
                .and().build();
    }
}
