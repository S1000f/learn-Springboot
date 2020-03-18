package my.portfolio.mySpringboot.web;

import my.portfolio.mySpringboot.web.Dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello2")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto2")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}
