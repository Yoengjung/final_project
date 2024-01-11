package kr.co.teamA.Haru.config.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationRequest {
    // 사용자 이름을 저장
    private String userId;
    // 사용자 비밀전호를 저장
    private String pwd;
}
