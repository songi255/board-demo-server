package com.board.boarddemoserver.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// User별 Post 확인 또한 필요함.(Join)

@Getter
@NoArgsConstructor
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String id;

    // TODO: 보안조치 고려 필요
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    // JPA 에서 Enum 을 String 타입으로 저장
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // Test 용도
    public UserInfo(Long no, String id, String password, String nickname, Role role) {
        this.no = no;
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }

    @Builder
    public UserInfo(String id, String password, String nickname, Role role) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }

    public UserInfo updateNickname(String nickname){
        this.nickname = nickname;
        return this;
    }

    public UserInfo updatePassword(String password){
        this.password = password;
        return this;
    }

    public String getRole(){
        return this.role.getKey();
    }
}
