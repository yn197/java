package com.yn.callback.domain;


import com.yn.callback.service.CallBack;

/**
 * 问题的人Person：
 *
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 18:11
 */
public class Person implements CallBack {
    private Genius genius;

    public Person(Genius genius) {
        this.genius = genius;
    }

    @Override
    public void callback(String string) {
        System.out.println("收到答案：" + string);
    }

    public void ask() {
        genius.answer(this);
    }

    /**
     * 提供一个支持异步回调的方法
     */
    public void askASyn() {
        System.out.println("创建新线程请教问题");
        new Thread(() -> genius.answer(this)).start();
        System.out.println("新线程已启动...");
    }
}
