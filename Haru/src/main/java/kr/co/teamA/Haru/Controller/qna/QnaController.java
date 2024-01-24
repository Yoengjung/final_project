package kr.co.teamA.Haru.Controller.qna;

import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Entity.Answer2;
import kr.co.teamA.Haru.Entity.Question;
import kr.co.teamA.Haru.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
 //   @GetMapping("/ansAdd")
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
    @GetMapping(value = "/questionList")
    public String getQuestion(){
        System.out.println("OK~~~~~~~~~~~~~~~~~~");
        //return questionService.getQuestionList();
        return "하이";
    }
    @GetMapping("/questionList2")
    public List<Map<String,String>> listQuestionAns(){
        List<Question> all =  questionService.getQuestionList();
        List<Map<String,String>> maps = new ArrayList<>();
        int i=0;
        for(Question e: all){
            Map<String,String> map = new HashMap<>();
            map.put("no",String.valueOf(e.getQnum()));
            map.put("category",e.getQcategroy());
            map.put("qcontent",e.getQcontent());
            map.put("title",e.getQtitle());
            map.put("writer",e.getQwriter());
            if(e.getStatue().equals("Y")){
                map.put("progress","완료");
            }else{
                map.put("progress","미답변");
            }
            

            LocalDateTime dateTime = LocalDateTime.parse(String.valueOf(e.getQdate()));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateTime.format(formatter);

            map.put("date",formattedDate);
            maps.add(map);
        }
        return maps;
    }
    @GetMapping("/questionDetails")
    public Map<String, String> listQuestionAnsDetils(int qnum, String status) {
        Optional<Question> questionOptional = questionService.getQuestionWithStatus(qnum, status);
        Map<String, String> map = new HashMap<>();

        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            System.out.println(question.getQtitle());

            map.put("no", String.valueOf(question.getQnum()));
            map.put("category", question.getQcategroy());
            map.put("qcontent", question.getQcontent());
            map.put("title", question.getQtitle());
            map.put("writer", question.getQwriter());

            if (status.equals("Y") && question.getAnswerList() != null && !question.getAnswerList().isEmpty()) {
                Answer2 answer = question.getAnswerList().get(0); // 가장 첫 번째 답변을 가져옴
                System.out.println(answer.getContent());
                map.put("answercontent", answer.getContent());
            }

            System.out.println("============================");
        } else {
            // 질문이 존재하지 않는 경우에 대한 처리를 여기에 추가할 수 있습니다.
            System.out.println("Question not found for qnum: " + qnum);
        }
        return map;
    }

}
