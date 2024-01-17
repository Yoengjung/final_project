package kr.co.teamA.Haru.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AnswerDTO {
    private String adminId;
    private Long answerNum;
    private String answerContent;
    private LocalDateTime answerCdate;
    private String qnaContent;
}
