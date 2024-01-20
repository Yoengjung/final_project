package kr.co.teamA.Haru.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@Table(name = "question")
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

    @CreationTimestamp
    private LocalDateTime qdate;

    @OneToMany(mappedBy = "question")
    private Set<Answer> answers = new HashSet<>();

}