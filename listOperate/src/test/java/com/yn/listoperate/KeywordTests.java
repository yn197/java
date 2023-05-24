package com.yn.listoperate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ListOperateApplication.class})
public class KeywordTests {

    /**
     * 学习关键字super和this
     */
    @Test
    public void contextLoads() {
        Son s = new Son();
        s.test(30);
    }

    @Data
    class Father {
        int a = 10;
    }

    @Data
    public class Son extends Father {
        int a = 20;

        public void test(int a) {
            System.out.println(super.a);//10
            System.out.println(this.a);//20
            System.out.println(a);//30
        }
    }
}
