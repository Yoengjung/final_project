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
@Table(name = "LOGLOGGIN")
public class LogLoggin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOGLOGGINNUM_SEQ_")
    @SequenceGenerator(name = "LOGLOGGINNUM_SEQ_", sequenceName = "LOGLOGGINNUM_SEQ_", allocationSize = 1)
    private Long LOGLOGGINNUM;
    

    @Column(nullable = false)
    private Long ACCESSINFO;

    @ManyToOne
    @JoinColumn(name = "ADMINID", referencedColumnName = "ADMINID")
    private ADMIN admin;

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    private Member member;

    @Column(nullable = false)
    private Date ACCESSTIME;

    @Column(length = 100, nullable = false)
    private String ACCESSPLACE;

    @Column(length = 255, nullable = false)
    private String ACCESSWAY;

}
