package kr.co.teamA.Haru.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String userId;   // 회원 아이디
    private String name;     // 회원 이름
    private String email;    // 회원 이메일


}
