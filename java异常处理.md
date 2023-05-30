# java异常处理

## 1 Exception 类的层次

所有的异常类是从 java.lang.Exception 类继承的子类。Exception 类是 Throwable(**可抛出**) 类的子类。

**Throwable**： 有两个重要的子类：Exception（异常）和 Error（错误），二者都是 Java 异常处理的重要子类，各自都包含大量子类。异常和错误的区别是：异常能被程序本身可以处理，错误是无法处理。 

Throwable类中常用方法如下:

```java
#1. 返回异常发生时的详细信息
public string getMessage();
 
#2. 返回异常发生时的简要描述
public string toString();
 
#3. 返回异常对象的本地化信息。使用Throwable的子类覆盖这个方法，可以声称本地化信息。如果子类没有覆盖该方法，则该方法返回的信息与getMessage（）返回的结果相同
public string getLocalizedMessage();
 
#4. 在控制台上打印Throwable对象封装的异常信息
public void printStackTrace();
```



异常类有两个主要的子类：IOException 类和 RuntimeException 类。

![](/img/异常图.png)

## 2 异常常见的处理方式

**抛出异常**，在方法上面使用throws 往事抛出

**捕捉异常** ，一般使用try-catch或者try-catch-finally

```java
try {  
	// 可能会发生异常的程序代码  
} catch (Type1 id1){  
	// 捕获并处置try抛出的异常类型Type1  
} catch (Type2 id2){  
	 //捕获并处置try抛出的异常类型Type2  
}finally {  
	// 无论是否发生异常，都将执行的语句块  
} 
```



## 3 项目中使用

**参考该项目模块common的exception**



