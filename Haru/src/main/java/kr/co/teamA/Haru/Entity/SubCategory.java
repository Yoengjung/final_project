package kr.co.teamA.Haru.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "SUBCATEGORY")
public class SubCategory {
    
    @Id
    private String subCategory;

    @JoinColumn(name = "mainCategory")
    private List<MainCategory> mainCategory;

    private Long placeIsOutDoor;
}
