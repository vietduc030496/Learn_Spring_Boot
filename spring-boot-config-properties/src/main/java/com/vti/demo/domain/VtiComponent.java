package com.vti.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@PropertySource(value = {"classpath:application-dev.properties"}, ignoreResourceNotFound = true)
@ConfigurationProperties(prefix = "vti.corporation")
@Component
public class VtiComponent {
	
	private String name;
	
	private String address;

}
