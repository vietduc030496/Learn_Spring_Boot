package com.vti.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.domain.VtiComponent;
import com.vti.demo.domain.VtiProperties;

@RestController
@RequestMapping("/api")
public class VtiController {
	
	@Autowired
	private VtiProperties properties;
	
	@Autowired
	private VtiComponent component;

	@GetMapping("/vti/properties")
	public String helloroperties() {
		return "hello " +  properties.getName() + " - " + properties.getAddress();
	}
	
	@GetMapping("/vti/component")
	public String helloComponenti() {
		return "hello " +  component.getName() + " - " + component.getAddress();
	}
}
