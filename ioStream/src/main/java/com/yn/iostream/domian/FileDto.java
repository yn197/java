package com.yn.iostream.domian;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/11/21 12:00
 */
@Data
public class FileDto implements Serializable {

    private String imgUrl;
    private String filePath;
}
