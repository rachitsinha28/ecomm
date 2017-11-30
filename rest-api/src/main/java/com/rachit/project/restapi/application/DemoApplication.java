package com.rachit.project.restapi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages="com.rachit.project.restapi.controllers")
@EntityScan("com.rachit.project.ecommerce.data.entities")
@EnableJpaRepositories(basePackages="com.rachit.project.ecommerce.data.repository")
@SpringBootApplication
public class DemoApplication {
	public static void main(String args[]){
		SpringApplication.run(DemoApplication.class, args);
	}
}
