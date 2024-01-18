package kr.co.teamA.Haru.Controller.answer;

import java.util.List;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Service.answer.AnswerService;

@RestController
public class AnswerController {

    private final AnswerService answerService;

    // 생성자를 통해 AnswerService를 주입받도록 수정
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

}
