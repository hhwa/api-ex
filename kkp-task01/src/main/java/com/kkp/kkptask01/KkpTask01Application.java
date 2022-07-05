package com.kkp.kkptask01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class KkpTask01Application {

	public static void main(String[] args) {
		SpringApplication.run(KkpTask01Application.class, args);
	}
	
	@RequestMapping("/")
	public void index() {
		
	}

}
