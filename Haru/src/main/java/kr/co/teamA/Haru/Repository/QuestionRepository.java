package kr.co.teamA.Haru.Repository;

import kr.co.teamA.Haru.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question> findByOrderByQnumDesc();

    // qnum and statue
    Optional<Question> findByQnumAndStatue(Integer qnum, String statue);
}
