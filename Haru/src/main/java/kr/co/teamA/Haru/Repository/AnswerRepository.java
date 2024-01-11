package kr.co.teamA.Haru.Repository;

import kr.co.teamA.Haru.Entity.Qna.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
