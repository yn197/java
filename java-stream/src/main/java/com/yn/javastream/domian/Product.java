package com.yn.javastream.domian;

import com.yn.javastream.service.Service01;
import com.yn.javastream.service.Service03;
import com.yn.javastream.service.TempFileCallback;
import lombok.Data;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/27 14:54
 */
@Data
public class Product {
    private Service01 service01;
    private Service03 service03;

    private TempFileCallback callback;
}
