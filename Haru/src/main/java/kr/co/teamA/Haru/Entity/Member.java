package kr.co.teamA.Haru.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {

    @Id
    private String userId;

    @Column(length = 100, nullable = false)
    private String pwd;

    @Column(length = 30, nullable = false)
    private String nickname;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 255)
    private String profileImg;
}
