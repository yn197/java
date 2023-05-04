package com.yn.easyexcell;

import com.baomidou.mybatisplus.annotation.DbType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.yn.easyexcell.mapper")
public class EasyExcellApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyExcellApplication.class, args);
	}
}
