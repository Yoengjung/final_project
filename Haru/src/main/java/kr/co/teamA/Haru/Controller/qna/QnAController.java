package kr.co.teamA.Haru.Controller.qna;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

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

    @PostMapping("/QuestionAdd")
    public void addQuestion(@RequestParam("qnaCategory") String qnaCategory, @RequestParam("qnaTitle") String qnaTitle,
            @RequestParam("qnaContent") String qnaContent) {
        System.out.println(qnaTitle);

        qnAService.createQnA(qnaCategory, qnaTitle, qnaContent);

    }

}
