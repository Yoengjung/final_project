package kr.co.teamA.Haru.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "MAINCATEGORY")
public class MainCategory {
    
    @Id
    @Column(length = 255)
    private String MainCategory;

    @Column
    private Long seasonInformation;
}
