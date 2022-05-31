package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController -> 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
//예전에 @ResponseBody 를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각
@RestController
public class HelloController {

    //@GetMapping : HTTP Method get 방식으로 요청을 받을수 있는 API
    //예전에는 @RequestMapping(method = ResquestMethod.Get) 으로 사용 되었으나.
    //이제 이 프로젝트는 /hello로 요청이 오면 문자열 hello를 반환하는 기능을 가지게 되었.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //@RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    //여기서는 외부에서 name 이란 이름으로 name(String name)에 저장하게됌.
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
