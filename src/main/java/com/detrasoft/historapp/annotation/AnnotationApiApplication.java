package com.detrasoft.historapp.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.detrasoft")
@SpringBootApplication(scanBasePackages = {"com.detrasoft",})
@EntityScan(basePackages = {"com.detrasoft",})
@EnableFeignClients
public class AnnotationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnotationApiApplication.class, args);
	}

}
