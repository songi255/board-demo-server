package com.board.boarddemoserver.config.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Session 에 저장된 User 정보를 SessionUser Class 패러미터로
 * 바로 주입하기 위한 Annotation
 *
 * @author Dave Shin
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
