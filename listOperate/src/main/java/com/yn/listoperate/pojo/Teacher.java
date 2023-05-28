package com.yn.listoperate.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Teacher implements Comparable<Teacher>{
    private int age;
    private String name;
    @Override
    public int compareTo(Teacher o) {
        return this.age-o.getAge();
    }
}
