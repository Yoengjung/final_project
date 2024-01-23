package kr.co.teamA.Haru.Controller.answer;

import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ans")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping(value ="/ansAdd", produces = "application/json;charset=UTF-8")
    public void answerAdd(@RequestBody Answer answer){
        System.out.println(answer.getQuestion());
        System.out.println(answer.getContent());
        answerService.addAnswer(answer);
    }


}
