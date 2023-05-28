# List集合去重方法

```java
package com.yn.arrydemo;

import java.util.*;
import java.util.stream.Collectors;

public class arrayTest1 {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 5, 7, 8, 34, 7, 2};
        List<Integer> integers = Arrays.asList(array);
        System.out.println("原集合：" + integers);
        method1(integers);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Arrays.stream(array).forEach(arr -> arrayList.add(arr));
        method2(arrayList);
        method3(arrayList);
        method4(arrayList);
        method5(arrayList);
        method6(arrayList);
    }

    /**
     * 1.自定义去重
     *
     * @param integers
     */
    private static void method1(List<Integer> integers) {
        ArrayList<Object> newList = new ArrayList<>();
        integers.forEach(
                str -> {
                    if (!newList.contains(str)) {
                        newList.add(str);
                    }
                }
        );
        System.out.println("去重集合：" + newList);
    }
    /**
     * 迭代器去重(无序)
     *
     * @param list
     */
    private static void method2(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            // 获取循环的值
            Integer item = iterator.next();
            // 如果存在两个相同的值
            if (list.indexOf(item) != list.lastIndexOf(item)) {
                // 移除最后那个相同的值
                iterator.remove();
            }
        }
        System.out.println("去重集合:" + list);
    }

    /**
     * HashSet去重(无序)
     *
     * @param list
     */
    private static void method3(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        System.out.println("去重集合:" + set);
    }
    /**
     * LinkedHashSet去重(有序)
     *
     * @param list
     */
    private static void method4(List<Integer> list) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        System.out.println("去重集合:" + set);
    }
    /**
     * TreeSet去重(无序)
     *
     * @param list
     */
    private static void method5(List<Integer> list) {
        TreeSet<Integer> set = new TreeSet<>(list);
        System.out.println("去重集合:" + set);
    }
    /**
     * Stream去重(有序)
     *
     * @param list
     */
    private static void method6(List<Integer> list) {
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println("去重集合:" + list);
    }
}
```



