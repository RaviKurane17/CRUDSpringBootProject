package com.springbootcrudproject.crudprojectdemo;

import org.hibernate.annotations.processing.Exclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class CrudprojectdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudprojectdemoApplication.class, args);
	}

}
