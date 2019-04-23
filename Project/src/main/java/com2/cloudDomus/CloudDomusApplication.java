package com2.cloudDomus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cloudDomus", "com.bean"})
public class CloudDomusApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudDomusApplication.class, args);
	}

}
