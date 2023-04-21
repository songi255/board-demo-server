package com.board.boarddemoserver.web.command.request;

import com.board.boarddemoserver.domain.post.Post;
import com.board.boarddemoserver.domain.user.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 게시글 작성 요청 Command
 *
 * 작성자 정보(author)는 Session 에서 처리한다.
 *
 * @author Dave Shin
 */

@Getter
@NoArgsConstructor
@Setter
public class PostPostRequest {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostPostRequest(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
