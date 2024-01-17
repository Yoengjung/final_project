package kr.co.teamA.Haru.Repository.answerRepository;

import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Entity.QnA;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    // QnA 엔티티에 해당하는 모든 답변을 찾는 메소드
    List<Answer> findByQna(QnA qna);

    // 사용자에 따른 답변 검색
    List<Answer> findByUserId(Integer userId);

    // 특정 내용을 포함하는 답변 검색
    List<Answer> findByAnswerContentContaining(String content);
}
