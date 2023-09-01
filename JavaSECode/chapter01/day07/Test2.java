package day07;

/**
 * ClassName: Test2
 * Package: day07
 * Description:
 *  对于你想输出一个对象的引用的值的时候，如果你没有自己写一个toString方法，那么就会调用Object这个类的方法
 *  如果自己写了，就调用自己的！
 * @Author 全家乐
 * @Create 2023/4/26 16:10
 * Version 1.0
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {   //右键 Generrate -> construction || alt+insert
        this.name = name;
        this.age = age;
    }

    public Person() {   //构造方法,默认会生成
    }
/*
       由于上边的数据被封装，需要set和get方法帮助
       自动写成 右键 -> Generate -> getter and setter
 */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void eat() {
        System.out.println("吃饭！");
    }

    public void show() {
        System.out.println(name + " " + age);
    }

    @Override   //注解
    public String toString() {
        return "数据是：Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test2 {
    public static void main(String[] args) {
        Person person = new Person("lisi",10);
        //person.setName("rose");
        System.out.println(person);
        person.show();
    /*    person.name = "zhangsan";
        person.eat();*/
    }
}
