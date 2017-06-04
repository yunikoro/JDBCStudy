package com.zhiheng.spgstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.*;


@RestController
@SpringBootApplication
public class SpgStudyApplication {
	
	@RequestMapping("/")
	public String home() {
		return "Hello world";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpgStudyApplication.class, args);
	}
}
