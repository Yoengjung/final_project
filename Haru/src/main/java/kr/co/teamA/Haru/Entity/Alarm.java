package kr.co.teamA.Haru.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import org.springframework.data.relational.core.sql.Like;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ALARM")
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALARM_SEQ")
    @SequenceGenerator(name = "ALARM_SEQ", sequenceName = "ALARM_SEQ", allocationSize = 1)
    private Long ALARMNUM;

    @OneToOne
    @JoinColumn(name = "QNANUM", referencedColumnName = "QNANUM")
    private QnA qna;

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "userId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "COMMENTNUM", referencedColumnName = "COMMENTNUM")
    private FeedComment feedcomment;


    @Column(nullable = false)
    private Long alarmTypes;

}
