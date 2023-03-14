package com.vti.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class VtiProperties {
	
	@Value("${vti.name}")
	private String name;
	
	@Value("${vti.address}")
	private String address;

}
