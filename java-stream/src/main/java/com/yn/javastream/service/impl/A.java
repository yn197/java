package com.yn.javastream.service.impl;


import com.yn.javastream.service.CallBack;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 17:48
 */
public class A {
    public static ACallBack ac;

    /**
     * 调用B中的方法
     */
    public void methodA(){
        B b = new B();
        System.out.println("调用了A类中的A方法");
        ac = new ACallBack();
        b.methodA(ac);
    }
    public static class ACallBack implements CallBack {
        @Override
        public void invoke() {
            System.out.println("调用了A类中回调类的invoke方法");
        }
    }
}
