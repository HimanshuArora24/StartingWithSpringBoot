package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import com.example.demo.SubmissionFormsApplication;

@ComponentScan
@SpringBootApplication
public class SubmissionFormsApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SubmissionFormsApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SubmissionFormsApplication.class, args);
	}

}
