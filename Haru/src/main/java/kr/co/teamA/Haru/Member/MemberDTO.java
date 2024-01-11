package kr.co.teamA.Haru.Member;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MemberDTO {
    private String userId;
    private String pwd;
    private String nickname;
    private String name;
    private String email;
    private String profileImg;
}
