package kr.co.teamA.Haru.Controller.myPlace;

import kr.co.teamA.Haru.DTO.GetRecommendList;
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
    
    @PostMapping("/getRecommendPlace")
    public List<ShowMyRecommendPlaceDTO> placeRecGet(@RequestBody GetRecommendList getRecommendListDto) {
        System.out.println(getRecommendListDto.toString());
        List<ShowMyRecommendPlaceDTO> placeList = placeRecommendListService.getRecommendList(getRecommendListDto);
        return placeList;
    }
}
