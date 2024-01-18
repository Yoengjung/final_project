package kr.co.teamA.Haru.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth2/")
public class DefaultController {

    @GetMapping("/indePath")
    public String defindex(){
        System.out.println("Test Index~~~~~~~~~~~");
        return "index.html";
    }
}
