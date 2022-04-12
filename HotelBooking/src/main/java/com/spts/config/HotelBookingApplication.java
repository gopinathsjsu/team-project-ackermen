package com.spts.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The packages of rest controllers must be the sub packages of  pckage of this class or use "scanbsepackes property as below"
@SpringBootApplication(scanBasePackages = {"com.spts.booking", "com.spts.login","com.spts.search","com.spts.signup"})
public class HotelBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}

}
