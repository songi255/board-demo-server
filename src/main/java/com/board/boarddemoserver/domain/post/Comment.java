package com.board.boarddemoserver.domain.post;


import com.board.boarddemoserver.domain.BaseTimeAuditEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;


}
