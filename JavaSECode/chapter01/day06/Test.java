package day06;

/**
 * ClassName: Test
 * Package: day06
 * Description:
 *   属于成员变量，编译器给默认值
 *   引用类型，默认为null；int float对应的0值
 *   boolean 默认值 false
 * @Author 全家乐
 * @Create 2023/4/24 19:48
 * Version 1.0
 */
class Person {
    public String name;
    public int age;

    public void eat() {
        System.out.println(name + "正在吃饭；");
    }
    public void show() {
        System.out.println("姓名："+name+" 年龄："+age);
    }
}
public class Test {
    public static void main1(String[] args) {
        Person person = new Person();
        person.name = "张三";
        person.age = 10;
        System.out.println(person.name);
        System.out.println(person.age);
        person.show();
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        person1 = person2;
    }
}
