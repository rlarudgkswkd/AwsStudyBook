package domain.posts;

import com.jojoldu.book.springboot.Application;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
//@SpringBootTest
@SpringBootTest(classes= Application.class)
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach //Junit 에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정, 다음 실행할때 데이터가 남으면 실패할수도 있어서 지우는것.
    public void cleanup() {
        postsRepository.deleteAll();

    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // .save 테이블 posts에 insert, update 쿼리 실행, id값있으면 update, 없으면 insert 쿼리 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("rlarudgkswkd@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); //모든데이터 조회 메서드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
