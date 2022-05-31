package com.jojoldu.book.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 룸북_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        //assertThat : assertj라는 테스트 검증 라이브러리의 검증 메소드, 대상을 메소드 인자로 받음. 메소드 체이닝 지원-> isEqualTo와 같이 이어서 사용가능
        assertThat(dto.getName()).isEqualTo(name);
        //isEqualTo : assertj의 동등 비교 메소드, assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공.
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
