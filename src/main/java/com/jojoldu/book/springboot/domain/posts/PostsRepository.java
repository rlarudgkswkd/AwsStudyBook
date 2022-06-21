package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//ibatis나 MyBatis 등에서 Dao 라고 불리는 DB Layer 접근자.
//인터페이스 생성후 JpaRespository를 상속하면 CRUD 메소드가 자동으로 생성됌.
public interface PostsRepository extends JpaRepository<Posts,Long>{

}
