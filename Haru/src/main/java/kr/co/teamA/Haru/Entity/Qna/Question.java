package kr.co.teamA.Haru.Entity.Qna;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Question {
    @jakarta.persistence.Id
    @GeneratedValue
    private Long Id;

    // 다수의 질문과 한명의 작성자
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    private String writer;

    private String title;

    private String contents;

    private LocalDateTime Date;

    // 시간 포맷 변경 메서드
    public String getFormattedDate(){
        if (Date == null) {
            return "";
        }
        return Date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }

}
