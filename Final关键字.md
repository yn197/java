# Final关键字

## 1.final关键字修饰变量值

**引用变量是无法改变的地址值，但是可以通过另外的一种方式进行改变引用变量的内容**

```java
/**
     * final修饰的关键字
     *
     * @param args
     */
    public static void main(String[] args) {
        final String aaa = "Hello Java";
        log.info("aaa:{},地址值:{}", aaa,aaa.hashCode());
        //引用变量无法改变
        //aaa="Hello c++";
        final StringBuffer stringBuffer = new StringBuffer("Hello Java");
        log.info("stringBuffer地址值:{}",stringBuffer.hashCode());
        //stringBuilder=new StringBuffer("Hello Php");
        stringBuffer.append(" And Php");
        log.info("stringBuffer:{},地址值:{}", JSON.toJSONString(stringBuffer),stringBuffer.hashCode());

    }
```



```java
15:55:45.238 [main] INFO com.yn.listoperate.KeywordTests - aaa:Hello Java,地址值:387417328
15:55:45.245 [main] INFO com.yn.listoperate.KeywordTests - 地址值:985655350
15:55:45.278 [main] INFO com.yn.listoperate.KeywordTests - stringBuffer:"Hello Java And Php",地址值:985655350
```





