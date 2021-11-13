package com.jpmc.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan({"com.jpmc.*"})
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
public class CrsJpmcAppApplication {

	public static void main(String[] args) {
		System.out.println("Initialization done");
		SpringApplication.run(CrsJpmcAppApplication.class, args);
	}

}
