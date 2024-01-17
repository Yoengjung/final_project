package kr.co.teamA.Haru.Service.qna;

import kr.co.teamA.Haru.Entity.Member;
import kr.co.teamA.Haru.Entity.QnA;
import kr.co.teamA.Haru.Repository.QnARepository.QnARepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class QnAService {

    private final QnARepository qnARepository;

    // 모든 QnA 가져오기
    public List<QnA> getAllQnA() {
        return qnARepository.findAll();
    }

    // QnA 생성
    public QnA createQnA(String category, String title, String content, Member userId) {
        QnA qnA = new QnA();
        qnA.setQnaCategory(category);
        qnA.setQnaTitle(title);
        qnA.setQnaContent(content);

        return qnARepository.save(qnA);
    }

    // QnA 수정
    public QnA updateQnA(Long id, String category, String title, String content) {
        QnA existingQnA = qnARepository.findById(id).orElse(null);
        if (existingQnA != null) {
            existingQnA.setQnaCategory(category);
            existingQnA.setQnaTitle(title);
            existingQnA.setQnaContent(content);
            return qnARepository.save(existingQnA);
        }
        return null;
    }

    // QnA 삭제
    public void deleteQnA(Long id) {
        qnARepository.deleteById(id);
    }
}
