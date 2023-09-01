package day07;

import java.util.Arrays;
import java.util.Date;

/**
 * ClassName: Student
 * Package: day07
 * Description:
 *面向对象的3大特性：封装、继承、多态
 *   封装：把类的实习细节进行隐藏，对外只提供一些交互的接口，仅对外公开接口和对象进行交互
 *   包：对类、接口等的封装机制的体现，是一种对类或者接口等的很好的组织方式
 *      同一工程，不同包内可以封装同名的类
 * @Author 全家乐
 * @Create 2023/4/26 14:27
 * Version 1.0
 */
class Student {
    //private String name;  只能在当前类当中使用
    public String name;
    public int age;

    public void show() {
        System.out.println("姓名："+name);
    }
}
public class test {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "zhangsan";
        Date date = new Date();
        //java.util.Date date = new java.util.Date();
        int[] arr = {1,2,3};
        Arrays.sort(arr);

        double x = 10;
        double y = 20;
        double result = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));   //Math.pow(a, b)a的b次方
    }
}
