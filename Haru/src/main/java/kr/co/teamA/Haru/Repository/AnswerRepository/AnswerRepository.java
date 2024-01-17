package kr.co.teamA.Haru.Repository.AnswerRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.co.teamA.Haru.Entity.Answer;
import kr.co.teamA.Haru.Entity.QnA;
import kr.co.teamA.Haru.Entity.ADMIN;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    // 특정 QnA에 대한 모든 답변 가져오기
    List<Answer> findByQnaNum(QnA qna);

    // 특정 사용자의 모든 답변 가져오기
    List<Answer> findByAdminId(ADMIN admin);

    // 특정 사용자의 특정 QnA에 대한 답변 가져오기
    List<Answer> findByAdminIdAndQnaNum(ADMIN admin, QnA qna);

    // 답변 내용에 특정 키워드가 포함된 답변 가져오기
    List<Answer> findByAnswerContentContaining(String contentKeyword);
}
