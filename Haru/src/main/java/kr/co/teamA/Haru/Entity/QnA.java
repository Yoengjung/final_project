package kr.co.teamA.Haru.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import org.hibernate.mapping.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "QNA")
public class QnA {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QNA_SEQ")
    @SequenceGenerator(name = "QNA_SEQ", sequenceName = "QNA_SEQ", allocationSize = 1)
    private Long QNANUM;

    @OneToOne(mappedBy = "qna")
    private Alarm alarm;

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "userId")
    private Member member;

    @Column(length = 100, nullable = false)
    private String QNACATEGORY;

    @Column(length = 255, nullable = false)
    private String QNATITLE;

    @Column(length = 500, nullable = false)
    private String QNACONTENT;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String QNASTATE;

    @Column(nullable = false)
    private Date QNACDATE;

}
