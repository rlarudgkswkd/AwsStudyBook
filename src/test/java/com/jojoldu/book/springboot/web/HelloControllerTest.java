package com.jojoldu.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(SpringRunner.class)
//테스트 진행시 JUnit 내장된 실행자 외에 다른 실행자를 실행. 스프링 부트 테스트와 JUnit사이에 연결자 역할을 함.

//@WebMvcTest(controllers = HelloController.class)
//테스트 어노테이션 중 WebMvc에 집중할수있는
//선언할경우 @Controller, @ControllerAdvice 등을 사용 가능
//단 @Service, @Component, @Repository 등은 사용x
//여기서는 컨트롤러만 사용하기에 선언하였음
@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
@WebMvcTest
//@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    //@Autowired
    //스프링이 관리하는 빈(Bean)을 주입 받음
    @Autowired
    private MockMvc mvc;
    //웹 api를 테스트 할때 사용
    //스프링 mvc 테스트의 시작점
    // 이 클래스로 http get, post 등에 대한 api테스트를 할수있음.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))// MockMvc를 통해 /hello 주소로 HTTP GET 요청을 하기, 아래는 체이닝으로 검증 기능 이어서
                .andExpect(status().isOk())// mvc.perform의 결과를 검증, HTTP Header의 Status를 검증, 200,404, 500 -> 여기서는 200을 검증
                .andExpect(content().string(hello));// mvc.perform 결과 검증, 응답 내용 본문을 검증, hello를 리턴하는데 이 값이 맞는지 검증
    }

    @Test
    public void 리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));

    }
}
