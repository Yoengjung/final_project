package kr.co.teamA.Haru.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PLACERECOMMENDLIST")
public class PlaceRecommendList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLACECOMMENDLIST_SEQ_")
    @SequenceGenerator(name = "PLACECOMMENDLIST_SEQ_", sequenceName = "PLACECOMMENDLIST_SEQ_", allocationSize = 1)
    private Long placeRecommendList;

    @OneToMany(mappedBy = "placeRecommendList") // Place 엔터티에 정의된 필드명 사용
    private List<Place> places;

    // 일대다(One-to-Many) 관계를 나타내는 필드 추가
    @OneToMany(mappedBy = "placeRecommendList") // Member 엔터티에 정의된 필드명 사용
    private List<Member> members;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String placeCdate;

}