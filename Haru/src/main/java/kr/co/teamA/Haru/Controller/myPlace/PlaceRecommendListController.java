package kr.co.teamA.Haru.Controller.myPlace;

import kr.co.teamA.Haru.DTO.ShowMyRecommendPlaceDTO;
import kr.co.teamA.Haru.Service.myPlace.PlaceRecommendListService;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PlaceRecommendListController {

    private final PlaceRecommendListService placeRecommendListService;
    public PlaceRecommendListController(PlaceRecommendListService placeRecommendListService) {
        this.placeRecommendListService = placeRecommendListService;
    }
    
    @GetMapping("/getRecommendPlace")
    public List<ShowMyRecommendPlaceDTO> placeRecGet(@RequestParam("userId") String userId, @RequestParam("startDate") String startDateStr, @RequestParam("endDate") String endDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;

        try {
            startDate = dateFormat.parse(startDateStr);
            endDate = dateFormat.parse(endDateStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
        List<ShowMyRecommendPlaceDTO> placeList = placeRecommendListService.getRecommendList(userId, startDate, endDate);
        return placeList;
    }
}
