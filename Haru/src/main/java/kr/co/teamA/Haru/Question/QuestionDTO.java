package kr.co.teamA.Haru.Question;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String writer;
    private String title;
    private String contents;
    private LocalDateTime date;
}
