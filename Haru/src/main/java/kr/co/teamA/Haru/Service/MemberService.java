package kr.co.teamA.Haru.Service;

import kr.co.teamA.Haru.DTO.UserIdDTO;
import kr.co.teamA.Haru.Repository.MemberRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int CheckDuplicateUserId(String userId) {
        UserIdDTO checkUserId = memberRepository.findUserIdById(userId);
        if (checkUserId != null) {
            return 1;
        } else {
            return 0;
        }
    }

}
