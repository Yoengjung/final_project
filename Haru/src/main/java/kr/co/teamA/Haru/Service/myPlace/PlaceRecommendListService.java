package kr.co.teamA.Haru.Service.myPlace;

import kr.co.teamA.Haru.DTO.ShowMyRecommendPlaceDTO;
import kr.co.teamA.Haru.Repository.PlaceRecommendListRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PlaceRecommendListService {

    @Autowired
    private PlaceRecommendListRepository placeRecommendList;

    public List<ShowMyRecommendPlaceDTO> getRecommendList(String userId, Date startDate, Date endDate) {
        return placeRecommendList.findAllTwo(userId, startDate, endDate);
    }
}
