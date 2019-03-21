package com.eocencle.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(value="com.eocencle.template.dao")
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}
}
