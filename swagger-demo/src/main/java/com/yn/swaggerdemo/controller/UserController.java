package com.yn.swaggerdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Index服务", value = "该参数没什么意义，在UI界面上也看到，所以不需要配置")
public class UserController {

    @RequestMapping("/users")
    @ApiOperation(value = "helloworld",httpMethod = "GET", notes = "helloworld")
    public String test1() {
        return "test1";
    }
}
