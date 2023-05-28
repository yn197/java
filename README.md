# 模块功能
## 1.模块功能

```
--devtools                          --热部署以及热部署插件
--easy-excell                       -- easy-excel整合
--java-common                       --公共包依赖
--listOperate                       --List的交集，并集，差集等操作,super与this区别，静态变量和实例变量,
                                    Integer与int的默认值，arraylist实现Comparable自定义排序
--mapTraversal                      --Map的遍历方式，后续补充map我喜欢用的其他API
--swagger-demo                      --swagger文档，jasypt加密登录用户名密码
--callback                          --java异步回调机制
--java-stream                       --jdk1.8 stream常用操作，以及guava，common-lang工具包使用
--ioStream                          --IO流操作
```

## 2.ArryList自定义排序

````java
1.实体类实现Comparable接口

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


Teacher s2=new Teacher(19,"李四");
Teacher s1=new Teacher(18,"张三");
Teacher s3=new Teacher(20,"王五");
List<Teacher> teachers= new ArrayList();
teachers.add(s2);
teachers.add(s3);
teachers.add(s1);
Collections.sort(teachers);
log.info("老师:{}", JSON.toJSONString(teachers));

2.方法中使用Comparator
Student s5=new Student(19,"李四");
Student s4=new Student(18,"张三");
Student s6=new Student(20,"王五");
List<Student> students= new ArrayList();
students.add(s5);
students.add(s4);
students.add(s6);
Collections.sort(students, Comparator.comparingInt(Student::getAge));
log.info("学生:{}", JSON.toJSONString(students));
````

## 3.构造器 Constructor 是否可被 override

构造器 Constructor 不能被继承，因此不能重写 Override，但可以被重载 Overload

## 4.接口是否可继承接口? 抽象类是否可实现(implements) 接口? 抽象类是否可继承具体类(concrete class)? 抽象类中是否可以有静态的 main 方法？

接口可以继承接口。抽象类可以实现(implements)接口，抽象类是否可继承具体类。抽象类中可以有静态的 main 方法。

只有记住抽象类与普通类的唯一区别就是不能创建实例对象和允许有 abstract 方法。