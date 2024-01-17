package kr.co.teamA.Haru.Repository;

import kr.co.teamA.Haru.Entity.PlaceRecommendList;
import kr.co.teamA.Haru.Entity.UserInterestCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRecommendListRepository extends JpaRepository<PlaceRecommendList, Long> {
}
