package com.devtiago.refurbtracker.refurb_tracker_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.devtiago.refurbtracker")
public class RefurbTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefurbTrackerAppApplication.class, args);
	}

}
