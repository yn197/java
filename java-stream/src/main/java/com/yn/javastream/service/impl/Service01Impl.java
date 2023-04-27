package com.yn.javastream.service.impl;


import com.yn.javastream.service.Service01;
import org.springframework.stereotype.Service;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 14:34
 */
@Service
public class Service01Impl implements Service01 {
    @Override
    public void play() {
        System.out.println("Service01Impl打篮球");
    }
}
