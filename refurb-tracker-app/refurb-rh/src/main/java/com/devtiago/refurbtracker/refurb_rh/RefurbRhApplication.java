package com.devtiago.refurbtracker.refurb_rh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
@EnableJpaRepositories(basePackages = {
		"com.devtiago.refurbtracker.refurb_rh.repository",
		"com.devtiago.refurbtracker.refurb_core.repository"
})
@EntityScan(basePackages = {
		"com.devtiago.refurbtracker.refurb_rh.entity",
		"com.devtiago.refurbtracker.refurb_core.entity"
})
*/
@SpringBootApplication(scanBasePackages = {
		"com.devtiago.refurbtracker.refurb_rh",
		"com.devtiago.refurbtracker.refurb_core"
})
public class RefurbRhApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefurbRhApplication.class, args);
	}

}
