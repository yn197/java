package com.yn.listoperate.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CatServiceImpl implements CatService{
    @Override
    public void eat(String msg) {
        log.info("猫吃鱼");
    }
}
