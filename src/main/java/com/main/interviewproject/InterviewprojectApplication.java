package com.main.interviewproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan("com.main.interviewproject.repository")//to scan repository files
@EntityScan("com.main.interviewproject.model")
@EnableJpaRepositories("com.main.interviewproject.repository")*/
public class InterviewprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewprojectApplication.class, args);
		System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
	}

}
