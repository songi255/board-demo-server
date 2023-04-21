package com.board.boarddemoserver.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Auditing 데이터를 추가하기 위한 Super Class.
 *
 * @author Dave Shin
 */

@Getter
@MappedSuperclass
// Auditing 활성화
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeAuditEntity {
    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime modifiedTime;
}
