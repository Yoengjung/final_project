package kr.co.teamA.Haru.Service;

import kr.co.teamA.Haru.Entity.Question;
import kr.co.teamA.Haru.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public void addQuestion(Question question){
        questionRepository.save(question);

    }
}
