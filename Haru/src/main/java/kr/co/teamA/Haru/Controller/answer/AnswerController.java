package kr.co.teamA.Haru.Controller.answer;

import org.springframework.web.bind.annotation.RestController;

import kr.co.teamA.Haru.Service.answer.AnswerService;

@RestController
public class AnswerController {

    private final AnswerService answerService;

    // 생성자를 통해 AnswerService를 주입받도록 수정
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

}
