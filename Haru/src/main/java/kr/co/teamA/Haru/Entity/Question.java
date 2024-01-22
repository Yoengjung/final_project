package kr.co.teamA.Haru.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
@Builder
public class Question {
    /*
    번호 qnum
    카테고리 qcategroy -> 이용문의/공지사항
    제목 qtitle
    내용 qcontent
    작성자 qwriter
    작성날짜 qdate
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "question_seq")
    @SequenceGenerator(sequenceName = "question_seq",name = "question_seq",allocationSize = 1)
    private Integer qnum;

    @Column(length = 50)
    private String qcategroy;

    @Column(length = 200)
    private String qtitle;

    @Column(columnDefinition = "CLOB")
    private String qcontent;

    @Column(length = 50)
    private String qwriter;


    private String statue;

    private LocalDateTime qdate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer2> answerList;

}
