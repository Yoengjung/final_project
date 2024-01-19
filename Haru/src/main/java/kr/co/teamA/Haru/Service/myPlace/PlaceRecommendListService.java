package kr.co.teamA.Haru.Service.myPlace;

import kr.co.teamA.Haru.DTO.GetRecommendList;
import kr.co.teamA.Haru.DTO.ShowMyRecommendPlaceDTO;
import kr.co.teamA.Haru.Repository.PlaceRecommendListRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PlaceRecommendListService {

    @Autowired
    private PlaceRecommendListRepository placeRecommendList;

    public List<ShowMyRecommendPlaceDTO> getRecommendList(GetRecommendList getRecommendListDto) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;

        try {
            startDate = dateFormat.parse(getRecommendListDto.getStartdate());
            endDate = dateFormat.parse(getRecommendListDto.getEnddate());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return placeRecommendList.findAllTwo(getRecommendListDto.getUserid(), startDate, endDate);
    }
}
