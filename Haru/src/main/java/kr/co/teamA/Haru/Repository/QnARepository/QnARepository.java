package kr.co.teamA.Haru.Repository.QnARepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.teamA.Haru.Entity.Member;
import kr.co.teamA.Haru.Entity.QnA;

public interface QnARepository extends JpaRepository<QnA, Long> {

    List<QnA> findByUserId(Member userId);

    // 특정 카테고리의 모든 QnA 가져오기
    List<QnA> findByQnaCategory(String category);

    // 제목 또는 내용에 특정 키워드가 포함된 QnA 가져오기
    List<QnA> findByQnaTitleContainingOrQnaContentContaining(String titleKeyword, String contentKeyword);

    // 특정 사용자의 특정 카테고리의 QnA 가져오기
    List<QnA> findByUserIdAndQnaCategory(Member userId, String qnaCategory);
}
