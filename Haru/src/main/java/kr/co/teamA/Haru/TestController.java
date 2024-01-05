package kr.co.teamA.Haru;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/hello")
    public String hello(){
        return "깃허브 변경되는지 확인";
    }
}
