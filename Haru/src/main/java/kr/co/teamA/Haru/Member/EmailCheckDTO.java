package kr.co.teamA.Haru.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailCheckDTO {
    private String email;
    private String authCode;
    public String getEmail() {
        return this.email;
    }
}
