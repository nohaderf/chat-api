package com.project2.chatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ChatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApiApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer () {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				System.out.println("cors");
//				registry.addMapping("/ws/**")
//						.allowedOrigins("http://localhost:3000", "http://localhost:3000/");
//			}
//		};
//	}

}
