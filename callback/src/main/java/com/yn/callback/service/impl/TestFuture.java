package com.yn.callback.service.impl;

import java.util.concurrent.*;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 18:49
 */
public class TestFuture {
    public static void main(String[] args) {

        //实现一个Callable接口
        Callable<User> c = () -> {
            //这里是业务逻辑处理

            //让当前线程阻塞1秒看下效果
            Thread.sleep(1000);
            return new User("张三");
        };

        ExecutorService es = Executors.newFixedThreadPool(2);

        // 记得要用submit，执行Callable对象
        Future<User> fn = es.submit(c);
        // 一定要调用这个方法，不然executorService.isTerminated()永远不为true
        es.shutdown();
        // 无限循环等待任务处理完毕  如果已经处理完毕 isDone返回true
        while (!fn.isDone()) {
            try {
                //处理完毕后返回的结果
                User nt = fn.get();
                System.out.println(nt.name);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    static class User {
        private String name;

        private User(String name) {
            this.name = name;
        }
    }
}
