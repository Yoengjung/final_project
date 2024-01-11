package kr.co.teamA.Haru.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MailCertificationController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/emailCheck")
    public int sendEmail(@RequestBody EmailCheckDTO email) {
        int checkEmail = emailSenderService.duplicateEmail(email.getEmail());
        if (checkEmail == 0) {
            emailSenderService.sendEmail(email.getEmail());
            return 0;
        }
        else {
            return 1;
        }
    }

    @PostMapping("/emailCheck/certification")
    public boolean verifyCertificationNumber(@RequestBody EmailCheckDTO email, String authCode) {
        return emailSenderService.isVerify(email.getEmail(), authCode);
    }
}
