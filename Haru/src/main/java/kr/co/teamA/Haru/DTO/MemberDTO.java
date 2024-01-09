package kr.co.teamA.Haru.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
