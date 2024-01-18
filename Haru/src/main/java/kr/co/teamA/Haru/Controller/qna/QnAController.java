package kr.co.teamA.Haru.Controller.qna;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.co.teamA.Haru.Entity.Member;
import kr.co.teamA.Haru.Entity.QnA;

import kr.co.teamA.Haru.Service.qna.QnAService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class QnAController {

    // @Autowired
    // private QnARepository qnARepository;
    // @Autowired
    // private AnswerRepository answerRepository;
    @Autowired
    QnAService qnAService;

    @GetMapping("/testQuestionList")
    public List<QnA> listQuestion() {
        List<QnA> all = qnAService.getAllQnA();
        System.out.println(all);
        return all;
    }

    @GetMapping("/QuestionAdd")
    public void addQuestion(@RequestParam("qnaCategory") String qnaCategory,
            @RequestParam("qnaTitle") String qnaTitle,
            @RequestParam("qnaContent") String qnaContent,
            @RequestParam("userNickname") String userNickname) {
        System.out.println("요청이 수신되었습니다:");
        System.out.println("qnaCategory: " + qnaCategory);
        System.out.println("qnaTitle: " + qnaTitle);
        System.out.println("qnaContent: " + qnaContent);
        System.out.println("userNickname: " + userNickname);
        qnAService.createQnA(qnaCategory, qnaTitle, qnaContent, userNickname);
    }

    @GetMapping("/testQuestionList/{qnAId}")
    public ResponseEntity<QnA> viewDetail(@PathVariable Long qnAId) {
        System.out.println("현재 페이지의 프라이머리 키는 " + qnAId);
        QnA qnA = qnAService.getQnAById(qnAId);
        if (qnA != null) {
            return new ResponseEntity<>(qnA, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
