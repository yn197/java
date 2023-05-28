package com.yn.listoperate;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽象类
 */
@Slf4j
public abstract class AbstractAnimal {
    String name;

    public AbstractAnimal() {
        log.info("我是AbstractAnimal的构造方法");
    }

    static String getName() {
        return null;
    }
}
