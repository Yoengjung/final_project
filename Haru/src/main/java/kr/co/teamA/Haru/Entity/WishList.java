package kr.co.teamA.Haru.Entity;

import java.util.List;

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
@Table(name = "WISHLIST")
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WISHLIST_SEQ_")
    @SequenceGenerator(name = "WISHLIST_SEQ_", sequenceName = "WISHLIST_SEQ_", allocationSize = 1)
    private Long wishListNum;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Member> member;

    @JoinColumn(name = "placeNumber")
    private List<Place> place;
}
