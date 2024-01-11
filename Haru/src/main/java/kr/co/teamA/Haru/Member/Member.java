package kr.co.teamA.Haru.Member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mems_seq")
    @SequenceGenerator(name = "mems_seq", sequenceName = "MEMS_SEQ", allocationSize = 1)
    private Long idx;
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
