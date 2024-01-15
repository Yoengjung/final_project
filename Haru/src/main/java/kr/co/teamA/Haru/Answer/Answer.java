package kr.co.teamA.Haru.Answer;

import jakarta.persistence.*;
import kr.co.teamA.Haru.Question.Question;
import kr.co.teamA.Haru.User.SiteUser;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "answer_seq")
    @SequenceGenerator(sequenceName = "answer_seq",name = "answer_seq",allocationSize = 1)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToOne
    private Question question;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter ;
}
