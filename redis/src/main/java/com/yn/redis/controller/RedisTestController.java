package com.yn.redis.controller;


import com.yn.redis.service.RedisDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Resource
    private RedisDemoService redisDemoService;

    @GetMapping("/test")
    public void testRedis() throws Exception {
        redisDemoService.test();
    }
}
