package com.shortener;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@OpenAPIDefinition(info = @Info(title = "Shortener API"))
@SpringBootApplication
@EnableCaching
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
