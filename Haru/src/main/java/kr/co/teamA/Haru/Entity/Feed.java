//package kr.co.teamA.Haru.Entity;
//
//import jakarta.persistence.*;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//public class Feed {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long feedNum;
//
//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private Member member;
//
//    @ManyToOne
//    @JoinColumn(name = "placeNumber", nullable = false)
//    private Place place;
//
//    @Column(length = 500, nullable = false)
//    private String feedContent;
//
//    @Column(length = 255, nullable = false)
//    private String feedCategory;
//
//    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime feedCreationDate;
//
//    @Column(length = 255)
//    private String feedHashTag;
//}
