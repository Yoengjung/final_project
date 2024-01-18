package kr.co.teamA.Haru.Service.answer;

import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Entity.QnA;
import kr.co.teamA.Haru.Repository.AnswerRepository.AnswerRepository;
import kr.co.teamA.Haru.Repository.QnARepository.QnARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final QnARepository qnARepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, QnARepository qnARepository) {
        this.answerRepository = answerRepository;
        this.qnARepository = qnARepository;
    }

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public List<Answer> getAnswerContentByQnaNumString(Long qnaId) {
        Optional<QnA> optionalQnA = qnARepository.findById(qnaId);

        if (optionalQnA.isPresent()) {
            QnA qnA = optionalQnA.get();
            return answerRepository.findByQnaNum_QNANUM(qnA.getQNANUM());
        } else {
            return null;
        }
    }

    public void createAnswer(Long qnaId, String answerContent) {
        Optional<QnA> optionalQnA = qnARepository.findById(qnaId);

        if (optionalQnA.isPresent()) {
            QnA qnA = optionalQnA.get();

            // 새로운 Answer 객체 생성
            Answer newAnswer = new Answer();
            newAnswer.setQnaNum(qnA); // 해당하는 QnA와 연결
            newAnswer.setAnswerContent(answerContent); // 답변 내용 설정

            // Answer 저장
            answerRepository.save(newAnswer);
        } else {
            throw new RuntimeException("해당하는 QnA를 찾을 수 없습니다.");
        }
    }

    public void updateAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }

}
