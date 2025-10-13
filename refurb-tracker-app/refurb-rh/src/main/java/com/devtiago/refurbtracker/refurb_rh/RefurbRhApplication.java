package com.devtiago.refurbtracker.refurb_rh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
		"com.devtiago.refurbtracker.refurb_rh.repository",
		"com.devtiago.refurbtracker.refurb_core.repository"
})
public class RefurbRhApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefurbRhApplication.class, args);
	}

}
