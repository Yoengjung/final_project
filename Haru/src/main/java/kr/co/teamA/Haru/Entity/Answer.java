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
@Table(name = "ANSWER")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANSWER_SEQ_SEQ")
    @SequenceGenerator(name = "ANSWER_SEQ", sequenceName = "ANSWER_SEQ_SEQ", allocationSize = 1)
    private Long ANSWER_SEQNUM;

    @ManyToOne
    @JoinColumn(name = "QNANUM", referencedColumnName = "QNANUM")
    private QnA QNANUM;

    @Column(length = 500, nullable = false)
    private String ANSWERCONTENT;

    @Column(nullable = false)
    private Date ANSWERCData;

    @ManyToOne
    @JoinColumn(name = "ADMINID", referencedColumnName = "ADMINID")
    private ADMIN ADMINID;

    @Column(length = 500, nullable = false)
    private String QNACONTENT;

}
