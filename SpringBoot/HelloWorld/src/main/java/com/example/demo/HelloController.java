package com.example.demo;

import org.springframework.web.bind.annotation.*;
@RestController //for creating REST endpoints
public class HelloController {
	@GetMapping("/hello") //to retreve data, check endpoints
	public String hello(){
		return "Hello, Spring Boot";
		
	}

}
