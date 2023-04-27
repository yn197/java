package com.yn.javastream.controller;

import com.yn.javastream.service.Service02;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 14:44
 */
@RestController
@RequestMapping("test")
public class Controller  {
    @Resource
    private Service02 service02;

    @GetMapping("a")
    public void test() {
        service02.dump();
    }

    @GetMapping("b")
    public void test2() {
    service02.use();
    }
}
