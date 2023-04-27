package com.yn.javastream.service;


import com.yn.javastream.domian.Product;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 16:32
 */
public interface TempFileCallback {
    /**
     * 解析字节前调用
     *
     * @param product 识别参数
     */
    default void onParseBytesBefore(Product product) {
    }
}
