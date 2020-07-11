package com.kakao.swagger;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration 
@EnableSwagger2 
public class WebMvcConfiguarationSupport extends WebMvcConfigurationSupport { 
	@Override protected void addResourceHandlers(ResourceHandlerRegistry registry) { 
		registry.addResourceHandler("swagger-ui.html") 
		.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**") 
		.addResourceLocations("classpath:/META-INF/resources/webjars/"); 
		}
	}

