package com.yn.callback.domain;


import com.yn.callback.service.CallBack;

/**大神Genius类
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 18:12
 */
public class Genius {
    public void answer(CallBack callBack) {
        System.out.println("在忙其他事...");
        try {
            Thread.sleep(2000);
            System.out.println("忙完其他事，开始计算...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("天才计算出答案为：2");
        // 回调告诉你
        callBack.callback("2");
    }
}
