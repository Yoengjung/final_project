package kr.co.teamA.Haru.Controller.qna;

import java.util.List;

import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Entity.Member;
import kr.co.teamA.Haru.Entity.QnA;
import kr.co.teamA.Haru.Repository.AnswerRepository.AnswerRepository;
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

    @Autowired
    AnswerRepository answerRepository;

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

    @GetMapping("/deleteQnA/{qnAId}")
    public ResponseEntity<String> deleteQnA(@PathVariable Long qnAId) {
        try {
            System.out.println("삭제 요청이 수신되었습니다. qnAId: " + qnAId);

            // qnAId에 해당하는 QnA 삭제
            qnAService.deleteQnA(qnAId);

            return new ResponseEntity<>("QnA 삭제 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("QnA 삭제 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/answerQnA/{qnAId}")
    public void answerAdd(@PathVariable Long qnAId, String answer) {
        // System.out.println(qnAId);
        // return "hello";
        QnA oq = qnAService.getQnAById(qnAId);
        System.out.println(oq.isPresent());
        QnA q = oq.get();
        Answer ans = new Answer();
        ans.setAnswerContent();
        // 답변 데이터를 생성하기 위해서 관계 지정
        ans.setQnaNum(q);

        answerRepository.save(ans);
    }
}