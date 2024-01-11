package kr.co.teamA.Haru.Repository;

import kr.co.teamA.Haru.Entity.Qna.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
