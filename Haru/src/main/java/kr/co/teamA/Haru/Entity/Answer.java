package kr.co.teamA.Haru.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "answer_seq")
    @SequenceGenerator(sequenceName = "answer_seq",name = "answer_seq",allocationSize = 1)
    private Integer asnum;

    @Column(columnDefinition = "CLOB")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private Question question;
}