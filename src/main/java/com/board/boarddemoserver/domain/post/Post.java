package com.board.boarddemoserver.domain.post;

import com.board.boarddemoserver.domain.BaseTimeAuditEntity;
import com.board.boarddemoserver.domain.user.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 게시글 JPA Entity Class
 *
 *
 * @author Dave Shin
 */

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // TODO : Join 부분 검토 필요
    @ManyToOne
    @JoinColumn(name="USER_NO")
    private UserInfo author;

    @Builder
    public Post(String title, String content, UserInfo author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post(Long no, String title, String content, UserInfo author) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // post 수정. author 는 수정될 일이 없다.
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
