package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EntityScan(basePackages = "com.dev.model")  // Ajoute ceci si nécessaire
@EnableJpaRepositories(basePackages = "com.dev.repository")
@ComponentScan(basePackages = "com.dev")
public class MainApplication {

	@RequestMapping("/")
	String home() {
		return "Welcome to EmpowHer Health !";
	}

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}

