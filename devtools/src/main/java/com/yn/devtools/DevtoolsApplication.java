package com.yn.devtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevtoolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevtoolsApplication.class, args);
    }

    @RequestMapping("test")
    public String hello() {
        return "Hello  1213";
    }


}
