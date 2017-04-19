package com.youzi.yuchou.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.youzi.yuchou" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}