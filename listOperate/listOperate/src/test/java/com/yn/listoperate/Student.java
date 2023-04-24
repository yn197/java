package com.yn.listoperate;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Student implements Serializable {
    /**
     * The name of the student
     */
    private String username;
    /**
     * The age of the student
     */
    private Integer age;
}
