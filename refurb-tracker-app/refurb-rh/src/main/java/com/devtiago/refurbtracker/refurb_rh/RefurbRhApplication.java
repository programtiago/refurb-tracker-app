package com.devtiago.refurbtracker.refurb_rh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.devtiago.refurbtracker.refurb_rh",
		"com.devtiago.refurbtracker.refurb_core"
})
public class RefurbRhApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefurbRhApplication.class, args);
	}

}
