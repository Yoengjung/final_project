package kr.co.teamA.Haru.Service.answer;



import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Entity.Member;
import kr.co.teamA.Haru.Entity.QnA;

import kr.co.teamA.Haru.Repository.answerRepository.AnswerRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(QnA question, String content, Member user) {
        Answer answer = new Answer();
        answer.setAnswerContent(content);
        Date date = new Date(System.currentTimeMillis());
        answer.setAnswerCdate(date);
        answer.setQnaNum(question);
        answer.setUserId(user);
        this.answerRepository.save(answer);
        return answer;
    }

    public Answer getAnswer(Integer id) throws Exception {
        Optional<Answer> answer = this.answerRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            throw new Exception("answer not found");
        }
    }

    public void modify(Answer answer, String content) {
        answer.setAnswerContent(content);
        // 현재 시간을 java.sql.Date로 변환
        Date date = new Date(System.currentTimeMillis());
        answer.setAnswerCdate(date);
        this.answerRepository.save(answer);
    }

    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }


}