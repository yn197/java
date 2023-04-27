package com.yn.javastream;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yn.javastream.mapper")
public class JavaStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaStreamApplication.class, args);
	}

}
