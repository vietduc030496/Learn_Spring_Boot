package com.vti.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldRestController {

	@GetMapping("/hello")
	public String helloworld() {
		return "Hello World!";
	}
}
