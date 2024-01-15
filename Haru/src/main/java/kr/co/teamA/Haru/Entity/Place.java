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
@Table(name = "PLACE")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLACE_SEQ_")
    @SequenceGenerator(name = "PLACE_SEQ_", sequenceName = "PLACE_SEQ_", allocationSize = 1)
    private Long placeNumber;

    @Column(length = 255, nullable = false)
    private String placeName;

    @Column(length = 255, nullable = false)
    private String placeAddress;

    @OneToMany
    @JoinColumn(name = "subCategory")
    private List<SubCategory> subCategory;

    @Column(length = 255, nullable = false)
    private String placeImg;

    @Column(length = 255, nullable = false)
    private String placeLink;

    @Column(nullable = false)
    private Long placeScore;

    @Column(nullable = false)
    private Long placeActive;
}
