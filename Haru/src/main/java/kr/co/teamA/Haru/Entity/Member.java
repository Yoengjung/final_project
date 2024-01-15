package kr.co.teamA.Haru.Entity;

import jakarta.persistence.*;
// import kr.co.teamA.Haru.config.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(length = 100, nullable = false)
    private String userId;

    // @OneToMany(mappedBy = "member")
    // private List<QnA> qnas;

    // @OneToMany(mappedBy = "member")
    // private List<StressData> stressD;

    // @OneToMany(mappedBy = "member")
    // private List<Alarm> alarms;

    // @OneToMany(mappedBy = "member")
    // private List<Diary> diarys;

    // @OneToMany(mappedBy = "member")
    // private List<LOGLOGGIN> logloggins;

    @Column(length = 255, nullable = false)
    private String pwd;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 255, name = "profileImg")
    private String profileImg;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String cDate;

    @Column(length = 10)
    private String role;

}
