package com.yn.easyexcell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yn.easyexcell.mapper")
public class EasyExcellApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyExcellApplication.class, args);
	}
}
