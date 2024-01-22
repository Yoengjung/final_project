package kr.co.teamA.Haru.DTO;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
@Setter
public class QuestionDTO {
    private Integer qnum;
    private String qcategroy;
    private String qtitle;
    private String qcontent;
    private String qwriter;
    private LocalDateTime qdate;
}
