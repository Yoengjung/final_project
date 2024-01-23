package kr.co.teamA.Haru.Controller.qna;


import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Entity.Question;
import kr.co.teamA.Haru.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/qna")
public class QnaController {
    @Autowired
    private QuestionService questionService;

    @PostMapping(value = "/qnaAdd",produces = "application/json;charset=UTF-8")
    public void questionAdd(@RequestBody Question question){
        System.out.println(question.getQcategroy());
        System.out.println(question.getQtitle());
        questionService.addQuestion(question);
    }
    @PostMapping(value = "/ansAdd",produces = "application/json;charset=UTF-8")
    public void answerAdd(@RequestBody Map<String,String> map){
        questionService.answerAdd(map);

    }
//       @GetMapping("/ansAdd")
//    public void answerAdd(){
//        Optional<Question> oq = questionRepository.findById(2);
//        System.out.println(oq.isPresent());
//        Question q = oq.get();
//        Answer ans = new Answer();
//        ans.setContent("JPA에 대한 답변입니다.");
//        //답변 데이터를 생성하기 위해서 관계 지정
//        ans.setQuestion(q);
//        ans.setCreateDate(LocalDateTime.now());
//        answerRepository.save(ans);
//    }
}

