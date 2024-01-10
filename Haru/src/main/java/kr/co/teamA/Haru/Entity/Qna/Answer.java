package kr.co.teamA.Haru.Entity.Qna;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_answer_writer"))
    private String writer;

    @Lob
    private String contents;

    private LocalDateTime Date;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_question"))
    private Question question;


}
