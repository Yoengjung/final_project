package kr.co.teamA.Haru.Controller.Member;

import kr.co.teamA.Haru.Service.EmailSenderService;
import kr.co.teamA.Haru.Service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService, EmailSenderService mailSender) {
        this.memberService = memberService;
    }

    @GetMapping("/{userId}/userId")
    public int getUserId(@PathVariable("userId") String userId) {
        return memberService.CheckDuplicateUserId(userId);
    }

}
