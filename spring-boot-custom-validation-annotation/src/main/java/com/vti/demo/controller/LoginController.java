package com.vti.demo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.request.UserLoginRequest;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@PostMapping
	public String login(@Validated UserLoginRequest request) {
		
		return "Success";
	}

}
