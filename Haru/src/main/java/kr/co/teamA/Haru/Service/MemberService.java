package kr.co.teamA.Haru.Service;

import kr.co.teamA.Haru.DTO.MemberDTO;
import kr.co.teamA.Haru.DTO.UserIdDTO;
import kr.co.teamA.Haru.Entity.Member;
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
    // Member 엔티티를 생성하고 데이터베이스에 저장하는 메서드
    public Member create(MemberDTO boardDto){
        // Member 엔티티 객체를 생성
        Member entity = Member.builder()
                .userId(boardDto.getUserId())
                .pwd(boardDto.getPwd())
                .email(boardDto.getEmail())
                .name(boardDto.getName())
                .nickname(boardDto.getNickname())
                //.(new Date())
                .profileImg(boardDto.getProfileImg())
                //.createdAt(LocalDateTime.now())
                .build();
        // 생성된 Member 엔티티 객체를 MemberRepository의 save 메서드를 통해
        // 데이터베이스에 저장후 반환 !
        return memberRepository.save(entity);
    }

}
