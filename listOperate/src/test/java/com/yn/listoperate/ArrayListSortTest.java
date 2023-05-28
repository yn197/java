package com.yn.listoperate;

import com.alibaba.fastjson.JSON;
import com.yn.listoperate.pojo.Student;
import com.yn.listoperate.pojo.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ListOperateApplication.class})
public class ArrayListSortTest {
    /**
     * ArrayList 如何实现插入的数据按自定义的方式有序存放
     */
    @Test
    public void contextLoads() {
        Teacher s2 = new Teacher(19, "李四");
        Teacher s1 = new Teacher(18, "张三");
        Teacher s3 = new Teacher(20, "王五");
        List<Teacher> teachers = new ArrayList();
        teachers.add(s2);
        teachers.add(s3);
        teachers.add(s1);
        Collections.sort(teachers);
        log.info("老师:{}", JSON.toJSONString(teachers));

        Student s5 = new Student(19, "李四");
        Student s4 = new Student(18, "张三");
        Student s6 = new Student(20, "王五");
        List<Student> students = new ArrayList();
        students.add(s5);
        students.add(s4);
        students.add(s6);
        Collections.sort(students, Comparator.comparingInt(Student::getAge));
        log.info("学生:{}", JSON.toJSONString(students));
    }
}
