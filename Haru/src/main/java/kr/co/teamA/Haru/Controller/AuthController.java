package kr.co.teamA.Haru.Controller;

import kr.co.teamA.Haru.DTO.EmailCheckDTO;
import kr.co.teamA.Haru.DTO.MemberDTO;
import kr.co.teamA.Haru.DTO.UserIdDTO;
import kr.co.teamA.Haru.Repository.MemberRepository;
import kr.co.teamA.Haru.Service.EmailSenderService;
import kr.co.teamA.Haru.Service.MemberService;
import kr.co.teamA.Haru.config.dto.AuthenticationRequest;
import kr.co.teamA.Haru.config.dto.AuthenticationResponse;
import kr.co.teamA.Haru.config.utils.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private MemberService memberService;

    @Value("${profile-img-path}")
    private String imageDirctory;

    @GetMapping("/{userId}/userIdCheck")
    public ResponseEntity<?> duplicationUserIdCheck(@PathVariable String userId) {
        Optional dto = memberRepository.findUserIdById(userId);
        if (dto == null) {
            return ResponseEntity.ok(1);
        } else {
            return ResponseEntity.ok(0);
        }
    }

    @GetMapping("/{nickname}/nicknameCheck")
    public ResponseEntity<?> duplicationNicknameCheck(@PathVariable String nickname) {
        Optional dto = memberRepository.findNicknameByNickname(nickname);
        if (dto == null) {
            return ResponseEntity.ok(1);
        } else {
            return ResponseEntity.ok(0);
        }
    }

    @PostMapping("emailCheck")
    public ResponseEntity<?> emailCheck(@RequestBody EmailCheckDTO dto) {
        int result = memberRepository.findUserEmailByEmail(dto.getEmail());
        if (result == 0) {
            emailSenderService.sendEmail(dto.getEmail());
            return ResponseEntity.ok(1);
        } else {
            return ResponseEntity.ok(0);
        }
    }

    @PostMapping("/emailCheck/certification")
    public ResponseEntity<?> certification(@RequestBody EmailCheckDTO dto) {
        boolean result = emailSenderService.isVerify(dto.getEmail(), dto.getCode());
        if (result == true) {
            return ResponseEntity.ok(1);
        } else {
            return ResponseEntity.ok(0);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@ModelAttribute MemberDTO dto, @RequestPart("files") List<MultipartFile> files) {
        String imgName = null;
        for (MultipartFile multipartFile : files) {
            imgName = UUID.randomUUID() + getExtension(multipartFile.getOriginalFilename());
            String filePath = imageDirctory + imgName;
            try (FileOutputStream writer = new FileOutputStream(filePath)) {
                writer.write(multipartFile.getBytes());
            } catch (Exception e) {
                throw new RuntimeException("Fail to upload files.");
            }
        }
        dto.setProfileImg(imgName);
        memberService.create(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            // AuthenticationManager를 사용하여 사용자 인증을 시도
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUserId(),
                            authenticationRequest.getPwd()));

            // 인증 성공 시, SecurityContextHolder에 인증 정보를 설정
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // JwtTokenProvider를 사용하여 JWT 토큰을 생성
            String jwt = jwtTokenProvider.createToken(authentication);

            // AuthenticationResponse에 JWT 토큰을 담아 클라이언트에게 반환
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (AuthenticationException e) {
            // 인증 실패 시 예외 처리
            return ResponseEntity.status(401).body("Authentication failed");
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        // 실제로 JWT 토큰 기반 인증에서 로그아웃은 클라이언트 측에서 토큰을 삭제하는 것으로 처리되지만,
        // 서버 측에서는 SecurityContextHolder의 컨텍스트를 클리어 해야 한다.
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Logout successful");
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
