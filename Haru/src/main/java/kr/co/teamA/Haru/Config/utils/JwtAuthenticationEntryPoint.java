package kr.co.teamA.Haru.config.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
// Spring Security에서 인증에 실패하거나 인증 헤더를 보내지 않은 경우에 호출되는 클래스
// 추상 클래스인 BasicAuthenticationEntryPoint를 상속 받아서 재정의 해서 사용한다.
// BasicAuthenticationEntryPoint 이 클래스는 기본적인 HTTP 기반 인증 실패 처리를 구현한 클래스이다.
// Spring의 컴포넌트임

@Component
public class JwtAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // HTTP 응답 상태를 401로 설정 인증되지 않은 요청값으로 상태값을 응답으로 설정한다.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // 마임 타입을 json으로 설정
        response.setContentType("application/json");
        // 에러 메세지를 보낸다.
        response.getWriter().write("{ \"message\": \"" + authException.getMessage() + "\" }");
    }
    // Bean의 속성이 설정도니 후에 호출
    @Override
    public void afterPropertiesSet() {
        // setRealmName 메소드를 호출하여, 인증 영역의 이름을 "JWT AUthenication"으로 설정
        setRealmName("JWT Authentication");
        super.afterPropertiesSet();
    }
}

