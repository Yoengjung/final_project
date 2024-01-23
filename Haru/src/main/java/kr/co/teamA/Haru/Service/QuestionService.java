package kr.co.teamA.Haru.Service;

import jakarta.transaction.Transactional;

import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Entity.Question;
import kr.co.teamA.Haru.Repository.AnswerRepository;
import kr.co.teamA.Haru.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        try {
            Integer qnum = Integer.parseInt(map.get("qnum"));
            Optional<Question> oq = questionRepository.findById(qnum);
            if (oq.isPresent()) {
                Answer answer = new Answer();
                answer.setContent(map.get("content"));

                answer.setQuestion(oq.get());
                answer.setCreateDate(LocalDateTime.now());
                answerRepository.save(answer);

                Question question = oq.get();
                question.setStatue("Y");
                questionRepository.save(question);
            } else {
                System.out.println("Question not found for qnum: " + qnum);
                // 여기서 적절한 예외를 던지거나 다른 처리를 할 수 있습니다.
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid qnum format: " + map.get("qnum"));
            // qnum 형식이 잘못된 경우의 처리를 여기에 추가합니다.
        }
    }
}