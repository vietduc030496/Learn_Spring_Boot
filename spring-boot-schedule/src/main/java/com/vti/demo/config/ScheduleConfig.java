package com.vti.demo.config;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class ScheduleConfig {
	
	
	/**
	 * Print 'Hello World' every 10 second
	 * 
	 */
	@Scheduled(fixedDelay = 10000)
	public void scheduleFixedHelloWorld() {
		System.out.println("Hello World-" + new Date());
	}

}
