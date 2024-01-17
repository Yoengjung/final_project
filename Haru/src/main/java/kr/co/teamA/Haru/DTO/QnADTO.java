package kr.co.teamA.Haru.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class QnADTO {
    private String userId;
    private Long QNANUM;
    private String qnaCategory;
    private String qnaTitle;
    private String qnaContent;
    private String qnaState;
    private LocalDateTime qnaCdate;
}
