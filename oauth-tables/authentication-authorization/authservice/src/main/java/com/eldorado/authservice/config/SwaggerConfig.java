//package com.eldorado.authservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
///**
// * Swagger Configration File
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.eldorado.userservice.controller"))
//				.paths(regex("/oauth.*")).build().apiInfo(metaData());
//	}
//	
//private ApiInfo metaData() {
//
//		return new ApiInfo("Spring Boot REST API", "Spring Boot REST API for EL DORADO App", "1.0",
//				"Terms of service",
//				new Contact("POD 2", "https://tools.publicis.sapient.com/bitbucket/projects/PSMS/repos/product-phase%22",
//						"xyz@publicissapient.com"),
//				"Apache License Version 2.2", "https://www.eldorado.com%22");
//
//	}
//}