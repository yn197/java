package com.yn.callback.controller;

import com.yn.callback.domain.Genius;
import com.yn.callback.domain.Person;

/**
 * 这模拟大神正在忙碌，线程睡眠2秒，忙碌完之后，开始帮忙计算答案，
 * 获得答案之后，调用CallBack接口的callback方法进行回调，通知结果。
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 18:38
 */

public class SynchronousController {

    public static void main(String[] args) {
        Genius genius = new Genius();
        Person you = new Person(genius);
        you.ask();
    }
}
