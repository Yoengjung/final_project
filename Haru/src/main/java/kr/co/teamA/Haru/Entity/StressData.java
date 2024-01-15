package kr.co.teamA.Haru.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "STRESSDATA")
public class StressData {

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "userId")
    private Member member;

    @Column(nullable = false)
    private Long FACEDATA;

    @Column(nullable = false)
    private Long DIARYDATA;

    @Column(nullable = false)
    private Long MEASUREDATA;

    @Column(nullable = false)
    private String STRESSSCORE;

    @Column(nullable = false)
    private Date STRESSCCDATE;

}
