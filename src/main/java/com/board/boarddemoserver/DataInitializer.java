package com.board.boarddemoserver;

import com.board.boarddemoserver.domain.post.Post;
import com.board.boarddemoserver.domain.post.PostsRepository;
import com.board.boarddemoserver.domain.user.Role;
import com.board.boarddemoserver.domain.user.UserInfo;
import com.board.boarddemoserver.domain.user.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * 개발환경에서 실행 시 초기 test 데이터 로딩
 *
 * @author Dave Shin
 */

@RequiredArgsConstructor
@Profile("dev")
@Component
public class DataInitializer {
    private final PostsRepository postsRepository;
    private final UserInfoRepository userInfoRepository;

    @EventListener(value = ApplicationReadyEvent.class)
    @Transactional
    public void initialize(){
        // Dummy User
        UserInfo user1 = userInfoRepository.save(new UserInfo("admin", "1234", "admin", Role.ADMIN));
        UserInfo user2 = userInfoRepository.save(new UserInfo("tom", "tom1234", "tommy", Role.USER));
        UserInfo user3 = userInfoRepository.save(new UserInfo("alice", "alice1234", "princess33", Role.USER));

        // Dummy Post
        // Data
        String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In id elementum turpis, eget sodales mi. Aliquam sem libero, maximus quis lorem id, auctor sollicitudin ligula. Nunc ornare ante nec libero egestas, id sollicitudin risus elementum. Aliquam luctus metus in purus sollicitudin accumsan. Ut ut mauris sapien. Pellentesque vitae ante condimentum, varius est in, pharetra urna. Praesent porttitor libero non sem sodales bibendum.";
        String[] lorems = lorem.split("[\\.]");
        UserInfo[] authors = {user1, user2, user3};
        Random random = new Random();

        int POST_CNT = 200;
        int CHUNK_CNT = 3;

        // Generation
        for (int i = 0; i < POST_CNT; i++){
            String title = "test-" + random.nextInt(Integer.MAX_VALUE);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < CHUNK_CNT; j++) {
                sb.append(lorems[random.nextInt(lorems.length)]).append(' ');
            }
            String content = sb.toString();
            // FIXME : Join 변경 필요
            UserInfo author = authors[random.nextInt(authors.length)];
            postsRepository.save(new Post(title, content, author));
        }

    }
}
