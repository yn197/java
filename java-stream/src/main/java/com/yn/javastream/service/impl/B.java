package com.yn.javastream.service.impl;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 17:48
 */
public class B {
    public void methodA(A.ACallBack ac) {
        System.out.println("调用了B中的A方法");
        ac.invoke();
    }
}
