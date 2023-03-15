package com.vti.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.vti.demo.domain.Student;

@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:bean.properties"})
public class ConfigurationBean {
	
	/**
	 * 
	 * See : application.properties
	 * 
	 * @return
	 */
	@Bean(name = "studentExpression")
	@ConditionalOnExpression(value = "${vti.feature.enable:false}")
	public Student initStudent() {
		System.out.println("Demo on expression in application.properties @ConditionalOnExpression");
		return new Student("Kopie", 27, "This is demo of @ConditionalOnExpression.");
	}
	
	@Bean(name = "studentJava")
	@ConditionalOnJava(value = JavaVersion.ELEVEN)
	public Student initStudentJavaCondition() {
		System.out.println("Demo on java version @ConditionalOnJava");
		return new Student("Kopie", 27, "This is demo of @ConditionalOnJava.");
	}
	
	/**
	 * See : bean.properties
	 * 
	 * @return
	 */
	@Bean(name = "studentProperty")
	@ConditionalOnProperty(prefix = "vti", name = "properties", havingValue  = "2023")
	public Student initStudentPropertiesCondition() {
		System.out.println("Demo on properties in bean.properties and @ConditionalOnProperty");
		return new Student("Kopie", 27, "This is demo of @ConditionalOnProperty.");
	}
	
	/**
	 * See : config.properties
	 * 
	 * @return
	 */
	@Bean(name = "studentResource")
	@ConditionalOnResource(resources = {"classpath:config.properties"})
	public Student initStudentResourceCondition() {
		System.out.println("Demo on properties in config.properties and @ConditionalOnResource");
		return new Student("Kopie", 27, "This is demo of @ConditionalOnResource.");
	}
	
	@Bean(name = "studentOnBean")
	@ConditionalOnBean(name = {"studentResource"}, value = {Student.class})
	public Student initStudentBean() {
		System.out.println("Demo @ConditionalOnBean");
		return new Student("Kopie", 27, "This is demo of @ConditionalOnBean.");
	}

	@Bean(name = "studentOnJava8")
	@Conditional(Java8Condition.class)
	public Student initStudentJavaEight() {
		System.out.println("Demo @Conditional with java 8");
		return new Student("Kopie", 27, "This is demo of @Conditional with custom annoatation.");
	}
}
