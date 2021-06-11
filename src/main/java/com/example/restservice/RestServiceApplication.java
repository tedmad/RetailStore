package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.example.restservice"))
				.build()
				.apiInfo(appDetails());
	}

	private ApiInfo appDetails(){
		return new ApiInfo(
				"User API",
				"A Net Payable User API for Retail Store",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Thamang Madile","http://teddymadile.com", "tmadile@gmail.com"),
				"API License",
				"http://teddymadile.com",
				Collections.emptyList()

		);
	}
}
