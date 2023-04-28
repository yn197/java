package com.yn.maptraversal;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * map的2个常用api
 */
@Slf4j
@SpringBootTest
public class Test2 {
    /**
     * computeIfPresent用法
     */
    @Test
    public void contextLoads() {
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射关系
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 重新计算鞋加上10%的增值税后的价值
        int shoesPrice = prices.computeIfPresent("Shoes", (key, value) -> value + value * 10 / 100);
        System.out.println("Price of Shoes after VAT: " + shoesPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);
    }

    /**
     * ComputeIfAbsent用法
     */
    @Test
    public void contextLoads2() {
        //统计同一个城市的人
        User user1 = new User().setCity("上海").setUsername("张三");
        User user2 = new User().setCity("苏州").setUsername("李四");
        User user3 = new User().setCity("福建").setUsername("王伟");
        User user4 = new User().setCity("上海").setUsername("小李");
        ArrayList<User> newArrayList = Lists.newArrayList();
        newArrayList.add(user1);
        newArrayList.add(user2);
        newArrayList.add(user3);
        newArrayList.add(user4);
        log.info("newArrayList数据:{}",newArrayList);

        HashMap<String, List<User>> map = new HashMap<>();
        newArrayList.forEach(str->map.computeIfAbsent(str.getCity(),k->new ArrayList<>()).add(str));
        log.info("分组之后的数据:{}",map);

    }

    @Data
    @Accessors(chain = true)
    class User{
        private String username;
        private String city;
    }
}
