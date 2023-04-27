package com.yn.javastream.service.impl;

import com.yn.javastream.domian.Product;
import com.yn.javastream.service.TempFileCallback;
import org.springframework.stereotype.Service;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 16:39
 */
@Service
public class AiFileService {
    public void getTempFileByFileIdAndFileSize(TempFileCallback tempFileCallback) {
        Product product = new Product();
        tempFileCallback.onParseBytesBefore(product);
//        return "12345";
    }
}
