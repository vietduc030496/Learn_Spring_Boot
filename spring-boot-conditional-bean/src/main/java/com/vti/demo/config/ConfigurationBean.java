package com.vti.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vti.demo.domain.Student;

@Configuration
public class ConfigurationBean {
	
	@Bean
	@ConditionalOnExpression(value = "${vti.feature.enable:true}")
	public Student initStudent() {
		System.out.println("Demo on expression @ConditionalOnExpression");
		return new Student("Kopie", 27, "This is demo of @ConditionalOnExpression.");
	}
	
	@Bean
	@ConditionalOnJava(value = JavaVersion.ELEVEN)
	public Student initStudentJavaCondition() {
		System.out.println("Demo on java version @ConditionalOnJava");
		return new Student("Kopie", 27, "This is demo of @ConditionalOnJava.");
	}

}
