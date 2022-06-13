package com.ceiba.inversiones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class InversionesApplication {

	public static void main(String[] args) {

		SpringApplication.run(InversionesApplication.class, args);
	}

}
