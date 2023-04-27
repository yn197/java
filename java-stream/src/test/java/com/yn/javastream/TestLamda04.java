package com.yn.javastream;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Predicate;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/21 11:12
 */
@SpringBootTest
public class TestLamda04 {
    //1.Predicate<T> 断定型接口  Boolean test(T t)
    @Test
    public void test01() {
        Boolean aBoolean = strHander(2, (p)->p.equals(2));
        System.out.println(aBoolean);
    }

    //需求用来处理字符串 去除空格,分割...
    public Boolean strHander(Integer str, Predicate<Integer>pre) {
        return pre.test(str);
    }
}
