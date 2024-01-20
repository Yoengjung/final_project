package kr.co.teamA.Haru.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "answer_seq")
    @SequenceGenerator(sequenceName = "answer_seq",name = "answer_seq",allocationSize = 1)
    private Integer anum;

    @Column(length = 50)
    private String acategroy;

    @Column(length = 200)
    private String atitle;

    @Column(columnDefinition = "CLOB")
    private String acontent;

    @Column(length = 50)
    private String awriter;

    @CreationTimestamp
    private LocalDateTime adate;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;

}
