package kr.co.teamA.Haru.Repository;

import kr.co.teamA.Haru.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
