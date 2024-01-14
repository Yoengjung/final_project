//package kr.co.teamA.Haru.Entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Place {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long placeNumber;
//
//    @Column(length = 255, nullable = false)
//    private String placeName;
//
//    @Column(length = 255, nullable = false)
//    private String placeAddress;
//
//    @OneToOne
//    @JoinColumn(name = "subCategory")
//    SmallCategory smallCategory;
//
//    @Column(length = 255, nullable = false)
//    private String placeImg;
//
//    @Column(length = 255, nullable = false)
//    private String placeLink;
//
//    @Column(nullable = false)
//    private Integer placeScore;
//
//    @Column(nullable = false)
//    private Integer placeOutdoor;
//
//    @Column(nullable = false)
//    private Integer placeActive;
//}
