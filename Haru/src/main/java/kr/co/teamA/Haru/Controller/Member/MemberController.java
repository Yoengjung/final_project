package kr.co.teamA.Haru.Controller.Member;


import kr.co.teamA.Haru.DTO.MemberDTO;
import kr.co.teamA.Haru.Service.EmailSenderService;
import kr.co.teamA.Haru.Service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@RestController
public class MemberController {

    private final MemberService memberService;

    // 이미지 저장 경로
    @Value("${file.upload-dir}")
    private String imageDirectory;

    public MemberController(MemberService memberService, EmailSenderService mailSender) {
        this.memberService = memberService;
    }

    @GetMapping("/{userId}/userId")
    public int getUserId(@PathVariable("userId") String userId) {

        return memberService.CheckDuplicateUserId(userId);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> handleFileUpload(@RequestParam("userId") String userId,
                                              @RequestParam("pwd") String pwd,
                                              @RequestParam("nickname") String nickname,
                                              @RequestParam("email") String email,
                                              @RequestParam("name") String name,
                                              @RequestParam("files") List<MultipartFile> files) {
        String imgName=null;
        for (MultipartFile multipartFile : files){
            imgName = UUID.randomUUID() + getExtension(multipartFile.getOriginalFilename());
            String filePath = imageDirectory + imgName;
            try (FileOutputStream writer = new FileOutputStream(filePath)) {
                writer.write(multipartFile.getBytes());
            }catch (Exception e){
                //log.error(e.getMessage(), e);
                throw new RuntimeException("Fail to upload files.");
            }
        }
        MemberDTO dto = new MemberDTO();
        dto.setUserId(userId);
        dto.setPwd(pwd);
        dto.setEmail(email);
        dto.setNickname(nickname);
        dto.setName(name);
        dto.setProfileImg(imgName);
        memberService.create(dto);
        return ResponseEntity.ok().body(dto);
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
