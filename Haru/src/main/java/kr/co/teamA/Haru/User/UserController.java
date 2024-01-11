package kr.co.teamA.Haru.User;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/form")
    public String form(){
        return "/user/form";
    }

    public String create(User user){
        userRepository.save(user);
        return "redirect:/users/list";
    }

    public String list(Model model) {
        model.addAttribute("user", userRepository.findAll());
        return "/user/list";
    }

//    public String loginForm
}
