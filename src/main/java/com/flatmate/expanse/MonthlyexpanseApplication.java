package com.flatmate.expanse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonthlyexpanseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonthlyexpanseApplication.class, args);
	}
}
