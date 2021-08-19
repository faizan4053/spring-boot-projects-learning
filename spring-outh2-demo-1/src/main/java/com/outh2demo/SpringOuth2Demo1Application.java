package com.outh2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class SpringOuth2Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringOuth2Demo1Application.class, args);
	}

}
