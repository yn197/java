package com.yn.listoperate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ListOperateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListOperateApplication.class, args);
    }

}
