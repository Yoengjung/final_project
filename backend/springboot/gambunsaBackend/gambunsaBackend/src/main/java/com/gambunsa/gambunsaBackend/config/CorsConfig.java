package com.gambunsa.gambunsaBackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // 허용할 엔드포인트 패턴을 지정
                .allowedOriginPatterns("http://localhost:8081") // 허용할 오리진 패턴을 지정 (Vue.js 애플리케이션의 주소)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드를 지정
                .allowCredentials(true); // 필요에 따라 쿠키를 허용할지 여부를 설정
    }
}
