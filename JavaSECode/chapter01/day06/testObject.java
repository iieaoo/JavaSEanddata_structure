package day06;

/**
 * ClassName: testObject
 * Package: day06
 * Description:
 *一般来说，一个Java文件只写一个类
 * 一个Java文件只能有一个public类
 * @Author 全家乐
 * @Create 2023/4/24 19:04
 * Version 1.0
 */
/*class Person {  //相当于一个模板
    public String name;
    public int age;

    public void eat() {
        System.out.println(name + "吃饭!");
    }
    public void sleep() {
        System.out.println("睡觉");
    }
}*/
class WashMachine {
    public String brand;
    public String type;
    public double weight;
    public double length;
    public double width;
    public double height;
    public String color;

    public void washClothes() {
        System.out.println("洗衣功能");
    }
    public void dryClothes() {
        System.out.println("脱水功能");
    }
}

public class testObject {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s);
    }
    public static void main1(String[] args) {
        WashMachine washMachine = new WashMachine();     //实例化一个对象
       /* Person person = new Person();
        person.age = 20;
        person.name = "张三";
        person.eat();
        System.out.println(person.name+" "+person.age);*/
    }
}
