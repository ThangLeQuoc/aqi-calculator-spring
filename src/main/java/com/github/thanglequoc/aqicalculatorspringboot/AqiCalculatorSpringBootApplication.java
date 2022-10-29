package com.github.thanglequoc.aqicalculatorspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AqiCalculatorSpringBootApplication {

	@GetMapping("/home")
	public String home() {
		return "Hello docker world";
	}

	public static void main(String[] args) {
		SpringApplication.run(AqiCalculatorSpringBootApplication.class, args);
	}

}
