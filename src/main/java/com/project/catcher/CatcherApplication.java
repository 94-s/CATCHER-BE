package com.project.catcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatcherApplication.class, args);
	}

}
