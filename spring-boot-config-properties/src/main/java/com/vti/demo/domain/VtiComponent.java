package com.vti.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@PropertySource(value = {"classpath:application-dev.properties"}, ignoreResourceNotFound = true)
@ConfigurationProperties(prefix = "vti.corporation")
@Component
public class VtiComponent {
	
	@Value("${vti.name}")
	private String name;
	
	@Value("${vti.address}")
	private String address;

}
