package com.kakao.swagger;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Profile({"local","dev"})
@EnableSwagger2
@Configuration 
public class SwaggerConfig extends WebMvcConfiguarationSupport{ 
	@Bean public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2) 
				.select() 
				.apis(RequestHandlerSelectors.basePackage("io.lpin.maa")) 
				.paths(PathSelectors.ant("/v1/api/**")) // /v1/api/** �� URL�鸸 ���͸� 
				.build() 
				.apiInfo(apiInfo()) 
				.enable(true) 
				; 
	} 
	
	private ApiInfo apiInfo() { 
		return new ApiInfoBuilder() 
				.title("API Ÿ��Ʋ") 
				.description("API �󼼼Ұ� �� ���� ��") 
				.version("1.0") 
				.build(); 
		} 
	
	@Override protected void addResourceHandlers(ResourceHandlerRegistry registry) { 
		registry.addResourceHandler("swagger-ui.html") 
		.addResourceLocations("classpath:/META-INF/resources/"); 
		registry.addResourceHandler("/webjars/**") 
		.addResourceLocations("classpath:/META-INF/resources/webjars/"); 
		}

	
	
}

