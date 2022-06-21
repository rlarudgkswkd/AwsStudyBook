package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter//룸북의 어노테이션
@NoArgsConstructor //룸북의 어노테이션
@Entity //JPA 어노테이션 ,테이블과 링크될 클래스임을 나타냄 , 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭 ex. SalesManager.java -> sales_manager table
public class Posts {
    @Id //해당 테이블의 pk 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙을 나타냅니다.
    private Long id;

    @Column(length = 500, nullable = false) //테이블 칼럼을 나타냄. 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 됌. 기본값에서 사이즈를 늘리고 싶을때 사용.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생상, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
