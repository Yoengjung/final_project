package kr.co.teamA.Haru.Controller.Member;

import kr.co.teamA.Haru.Service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{userId}/userId")
    public int getUserId(@PathVariable("userId") String userId) {
        return memberService.CheckDuplicateUserId(userId);
    }
}
