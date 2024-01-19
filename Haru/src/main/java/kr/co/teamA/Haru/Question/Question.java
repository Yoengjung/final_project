package kr.co.teamA.Haru.Question;

import jakarta.persistence.*;
import kr.co.teamA.Haru.Answer.Answer;
import kr.co.teamA.Haru.User.SiteUser;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "question_seq")
    @SequenceGenerator(sequenceName = "question_seq",name = "question_seq",allocationSize = 1)
    private Integer num;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToOne(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;

}
