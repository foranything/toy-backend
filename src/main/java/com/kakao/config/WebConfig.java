package com.kakao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//냠냠냠냠
		registry.addMapping("/**").allowedOrigins("http://localhost:3000", "https://toy-chat-d6cbe.web.app/", "https://toy-chat-d6cbe.firebaseapp.com");
	}
}
