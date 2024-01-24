package kr.co.teamA.Haru.Service;

import jakarta.transaction.Transactional;
import kr.co.teamA.Haru.Entity.Answer2;
import kr.co.teamA.Haru.Entity.Question;
import kr.co.teamA.Haru.Repository.AnswerRepository;
import kr.co.teamA.Haru.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public void addQuestion(Question question){
        question.setQdate(LocalDateTime.now());
        question.setStatue("N");
        questionRepository.save(question);
    }
    @Transactional
    public void answerAdd(Map<String, String> map) {
        System.out.println(map.get("content") + ":" + map.get("qnum"));
        Optional<Question> oq = questionRepository.findById(Integer.parseInt(map.get("qnum")));
        if (oq.isPresent()) {
            Answer2 answer2 = new Answer2();
            answer2.setContent(map.get("content"));

            answer2.setQuestion(oq.get());
            answer2.setCreateDate(LocalDateTime.now());
            answerRepository.save(answer2);

            // Update the status of the Question if needed
            Question question = oq.get();
            question.setStatue("Y");
            questionRepository.save(question);
        } else {
            // Handle the case where the question is not found
            System.out.println("Question not found for qnum: " + map.get("qnum"));
        }
    }

    public List<Question> getQuestionList(){
        return questionRepository.findByOrderByQnumDesc();
    }

    public Optional<Question> getQuestionWithStatus(Integer qnum, String status) {
        return questionRepository.findByQnumAndStatue(qnum, status);
    }


}
