package com.yn.callback.controller;

import com.yn.callback.domain.Genius;
import com.yn.callback.domain.Person;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 18:48
 */
public class AsynController {
    public static void main(String[] args) {
        Genius genius = new Genius();
        Person you = new Person(genius);
        you.askASyn();
    }
}
