package kr.co.teamA.Haru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HaruApplication {
	public static void main(String[] args) {
		SpringApplication.run(HaruApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.println("test");
				registry.addMapping("/**")
						.allowedOrigins("http://192.168.0.224:8081/", "http://localhost/")
						.allowedHeaders("*")
						.allowedMethods("*").maxAge(3600);
			}

		};
	}



}
