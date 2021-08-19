package com.outh2demo;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
//@EnableAuthorizationServer
public class SpringOuth2DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOuth2DemoApplication.class, args);
	}

}
