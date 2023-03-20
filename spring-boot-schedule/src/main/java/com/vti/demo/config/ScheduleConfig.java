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
	public void scheduleFixedDelay() {
		System.out.println("Hello World From Fixed Delay - " + new Date());
	}
	
	/**
	 * Print 'Hello World' every 20 second
	 * 
	 */
	@Scheduled(fixedRate = 20000)
	public void scheduleFixedRate() {
		System.out.println("Hello World From Fixed Rate - " + new Date());
	}
	
	/**
	 * Print 'Hello World' at 00:00:00 every day
	 * 
	 */
	@Scheduled(cron = "0 0 0 * * ?")
	public void scheduleCron() {
		System.out.println("Hello World From Cron - " + new Date());
	}

}
