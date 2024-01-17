package kr.co.teamA.Haru.Repository.qnaRepository;

import java.util.List;

import kr.co.teamA.Haru.Entity.QnA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QnARepository extends JpaRepository<QnA, Integer> {
    QnA findBytitle(String subject);

    QnA findBySubjectAndContent(String subject, String content);

    List<QnA> findBySubjectLike(String subject);

    Page<QnA> findAll(Pageable pageable);

    Page<QnA> findAll(Specification<QnA> spec, Pageable pageable);

    @Query("SELECT DISTINCT q FROM QnA q "
            + "LEFT JOIN q.userId u1 "
            + "LEFT JOIN q.answerList a "
            + "LEFT JOIN a.userId u2 "
            + "WHERE "
            + "q.qnaTitle LIKE %:kw% "
            + "OR q.qnaContent LIKE %:kw% "
            + "OR u1.username LIKE %:kw% "
            + "OR a.answerContent LIKE %:kw% "
            + "OR u2.username LIKE %:kw% ")
    Page<QnA> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}