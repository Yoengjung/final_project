package kr.co.teamA.Haru.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "ANSWER")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANSWER_SEQ_SEQ")
    @SequenceGenerator(name = "ANSWER_SEQ", sequenceName = "ANSWER_SEQ_SEQ", allocationSize = 1)
    private Long answerNum;

    @Column(length = 500, nullable = false)
    private String answerContent;

    @Column(nullable = false)
    private Date answerCdate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "adminId", referencedColumnName = "adminId")
    private ADMIN adminId;

    @Column(length = 500, nullable = false)
    private String qnaContent;

}
