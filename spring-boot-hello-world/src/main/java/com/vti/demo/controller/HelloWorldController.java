package com.vti.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloworld() {
		return "helloworld";
	}
}
