package kr.co.teamA.Haru.Service.qna;

import kr.co.teamA.Haru.DTO.UserIdDTO;
import kr.co.teamA.Haru.Entity.Member;
import kr.co.teamA.Haru.Entity.QnA;
import kr.co.teamA.Haru.Repository.MemberRepository;
import kr.co.teamA.Haru.Repository.QnARepository.QnARepository;
import kr.co.teamA.Haru.security.User;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QnAService {

    private final QnARepository qnARepository;

    private final MemberRepository memberRepository;

    // 모든 QnA 가져오기
    public List<QnA> getAllQnA() {
        return qnARepository.findAll();
    }

    // QnA ID로 QnA 정보 가져오기
    public QnA getQnAById(Long id) {
        System.out.println(id + "ㅎㅎ");
        return qnARepository.findById(id).orElse(null);
    }

    // QnA 생성
    public QnA createQnA(String category, String title, String content, String nickname) {
        QnA qnA = new QnA();

        qnA.setQnaCategory(category);
        qnA.setQnaTitle(title);
        qnA.setQnaContent(content);
        qnA.setQnaCdate(LocalDateTime.now());
        qnA.setQnaState("0");
        Optional<Member> optionalMember = memberRepository.findUserIdByNickname(nickname);

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            qnA.setUserId(member); // 여기서 setUserId에 Member 객체를 전달
            QnA savedQnA = qnARepository.save(qnA); // 저장된 QnA 객체를 반환 받음

            // 저장된 QnA 객체의 ID를 출력
            System.out.println("새로 생성된 QnA의 ID: " + savedQnA.getQNANUM());

            return savedQnA;
        } else {
            throw new RuntimeException("해당 닉네임에 해당하는 사용자를 찾을 수 없습니다. 닉네임: " + nickname);
        }
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
