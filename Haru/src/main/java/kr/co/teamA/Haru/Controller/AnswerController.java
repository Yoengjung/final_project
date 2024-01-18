package kr.co.teamA.Haru.Controller;

import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Entity.QnA;
import kr.co.teamA.Haru.Service.answer.AnswerService;
import kr.co.teamA.Haru.Service.qna.QnAService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("/testQuestionList/{qnAId}")
    public ResponseEntity<String> viewDetail(@PathVariable Long qnAId) {
        System.out.println("현재 페이지의 프라이머리 키는 " + qnAId);
        String answerContent = answerService.getAnswerContentByQnANum(qnAId);
        if (answerContent != null) {
            return new ResponseEntity<>(answerContent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    }
}
