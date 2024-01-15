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
@Table(name = "LIKE")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIKE_SEQ_")
    @SequenceGenerator(name = "LIKE_SEQ_", sequenceName = "LIKE_SEQ_", allocationSize = 1)
    private Long likeNum;

    @OneToMany
    @JoinColumn(name = "feedNum")
    private List<Feed> feed;

    @Column(length = 255, nullable = false)
    private String feedLikeBy;
}
