package kr.co.teamA.Haru.Question;

import jakarta.persistence.*;
import kr.co.teamA.Haru.Answer.Answer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "question_seq")
    @SequenceGenerator(sequenceName = "question_seq",name = "question_seq",allocationSize = 1)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToOne(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

}
