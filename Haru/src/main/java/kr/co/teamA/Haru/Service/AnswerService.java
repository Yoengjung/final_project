package kr.co.teamA.Haru.Service;

import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public void addAnswer(Answer answer) {
         answerRepository.save(answer);
    }

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }
}
