package kr.co.teamA.Haru.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class User {
    @Id
    @Column(nullable = false, length = 20, unique = true)
    @JsonProperty
    private String userId;      // 회원 아이디

    @JsonIgnore
    private String password;    // 비밀번호

    @JsonProperty
    private String name;        // 회원 이름

    @JsonProperty
    private String email;       // 회원 이메일

    // 아이디 일치확인 메서드
    public boolean matchId(Long newId) {
        if ( newId == null ) {
            return false;
        }
        return newId.equals(getUserId());
    }

    // 비밀번호 일치확인 매서드
    public boolean matchPassword(String newPassword) {
        if ( newPassword == null ) {
            return false;
        }
        return newPassword.equals(password);
    }

    // Update() 메서드
    public void update(User updatedUser) {
        this.email = updatedUser.email;
        this.name = updatedUser.name;
        this.password = updatedUser.password;
    }
}
