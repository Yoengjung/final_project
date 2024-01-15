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
@Table(name = "USERINTERESTCATEGORY")
public class UserInterestCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERINTERESTCATEGORY_SEQ_")
    @SequenceGenerator(name = "USERINTERESTCATEGORY_SEQ_", sequenceName = "USERINTERESTCATEGORY_SEQ_", allocationSize = 1)
    private Long id;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Member> member;

    @JoinColumn(name = "mainCategory")
    private List<MainCategory> mainCategory;
}
