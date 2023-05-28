package com.yn.listoperate;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ListOperateApplication.class})
public class VariantTest {

    /**
     * 静态变量和实例变量
     */
    public static int staticVar = 0;
    public int instanceVar = 0;

    public VariantTest() {
        staticVar++;
        instanceVar++;
        System.out.println("staticVar =" + staticVar + ",instanceVar ="+instanceVar);
    }

    public static void main(String[] args) {
        VariantTest variantTest = new VariantTest();
        VariantTest variantTest2 = new VariantTest();
    }

    public  static String aaa() {
        return "Hello, world";
        VariantTest.bbb();
    }


    public void bbb() {
        System.out.println("123");
    }
}