package kr.co.teamA.Haru.Controller.qna;

import kr.co.teamA.Haru.Entity.Question;
import kr.co.teamA.Haru.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qna")
public class QnaController {
    @Autowired
    private QuestionService questionService;
    @PostMapping(value = "/qnaAdd", produces = "application/json;charset=UTF-8")
    public void questionAdd(@RequestBody Question question){
        System.out.println(question.getQcategroy());
        System.out.println(question.getQtitle());
        questionService.addQuestion(question);
    }
}
