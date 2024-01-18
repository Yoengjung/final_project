package kr.co.teamA.Haru.Controller.member;

import kr.co.teamA.Haru.Entity.PlaceRecommendList;
import kr.co.teamA.Haru.Service.myPlace.PlaceRecommendListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PlaceRecommendListController {

    private final PlaceRecommendListService placeRecommendListService;
    public PlaceRecommendListController(PlaceRecommendListService placeRecommendListService) {
        this.placeRecommendListService = placeRecommendListService;
    }

    @PostMapping("/getRecList")
    public List<PlaceRecommendList> getRecommendList(@RequestParam("id") String userId, @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        System.out.println("id : " + userId);
        System.out.println("startDate : " + startDate);
        System.out.println("endDate : " + endDate);

        List<PlaceRecommendList> recList = placeRecommendListService.getRecommendList(userId, startDate, endDate);
        return recList;
    }
}
