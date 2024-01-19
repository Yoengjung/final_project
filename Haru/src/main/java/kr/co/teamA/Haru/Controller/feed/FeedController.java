package kr.co.teamA.Haru.Controller.feed;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.teamA.Haru.Service.feed.FeedService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class FeedController {

    private final FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/feedList")
    public Map<String, Object> getFeedList() {

        Map<String, Object> feedList = feedService.getFeedList();

        return feedList;
    }

    @PostMapping("/addFeedComment")
    public void addFeedComment(@RequestParam Map<String, String> data) {
        int feedNum = Integer.parseInt(data.get("feedNum"));
        String userId = data.get("userId");
        String feedCommentContent = data.get("feedCommentContent");

        feedService.addFeedComment(feedNum, userId, feedCommentContent);
    }

    @Transactional
    @PostMapping("/modifyFeedLike")
    public void modifyFeedLike(@RequestParam Map<String, String> data) {
        int feedNum = Integer.parseInt(data.get("feedNum"));
        String userId = data.get("userId");

        feedService.modifyFeedLike(feedNum, userId);
    }

}
