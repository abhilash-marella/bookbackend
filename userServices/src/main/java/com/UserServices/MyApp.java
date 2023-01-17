package com.UserServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@SecurityScheme(
		name = "security_scheme", 
		scheme = "bearer", 
		type = SecuritySchemeType.HTTP, 
		in = SecuritySchemeIn.HEADER
	)
@EnableFeignClients
public class MyApp {
	
	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}

}
