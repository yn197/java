package com.yn.javastream.service.impl;

import com.yn.javastream.domian.Product;
import com.yn.javastream.service.Service02;
import com.yn.javastream.service.Service03;
import com.yn.javastream.service.TempFileCallback;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 14:34
 */
@Service
public class Service02Impl extends Service01Impl implements Service02, Service03, TempFileCallback {
    @Resource
    private AiFileService aiFileService;

    @Override
    public void dump() {
        super.play();
        System.out.println("Service02Impl跳");
    }

    @Override
    public void use() {
        Product product = new Product();
        product.setCallback(this);
        aiFileService.getTempFileByFileIdAndFileSize(product.getCallback());
    }

    @Override
    public void sing() {
        System.out.println("Service03 唱歌");
    }

    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }

    @Override
    public void method3() {
        System.out.println("method3");
    }

    @Override
    public void onParseBytesBefore(Product product) {
        System.out.println("这是一个回调的方法");
    }
}
