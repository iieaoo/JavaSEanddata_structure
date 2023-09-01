package demo7;

import java.util.Objects;

/**
 * ClassName: Test
 * Package: demo7
 * Description:
 *   浅拷贝：克隆和原来的指向同一个对象 深拷贝
 *  Cloneable空接口 作用：表示当前 是可以被克隆的
 *  抽象类和接口类的区别：
 *      抽象类中可以包含普通方法和普通字段，这样的普通方法和字段可以被子类直接使用（不必重写），
 *      接口类不能包含普通方法，子类必须重写所有的抽象方法
 *  Object:所有类的父类
 *      缺点：每次使用都要new
 *      使用场景：只用一次
 * @Author 全家乐
 * @Create 2023/5/2 14:49
 * Version 1.0
 */
class Animal {}
class Dog {
    public void func1(){}
    public void func2(){}
    public void func3(){}
}

class Money implements Cloneable {
    public double money = 12.25;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Student implements Cloneable{
    public String name;
    public Money m = new Money();

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //只是克隆了Student对象
        Student student = (Student)super.clone();
        //克隆了Student对象 里面的Money对象
        student.m = (Money) this.m.clone();
        return student;
        //return super.clone();
    }
   /* public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        //指向同一个对象
        if(this == obj) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student student = (Student) obj;

        if (this.name.equals(student.name)) {
            return true;
        }
        return false;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
public class Test {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "zhangsan";

        Dog dog = new Dog();
        boolean flg =  student1.equals(dog);
        System.out.println(flg);

        //Student student2 = student1;
        /*Student student2 = new Student();
        student2.name = "zhangsan";*/

        /*System.out.println(student1 == student2);
        boolean flg =  student1.equals(student2);
        System.out.println("flg " + flg);*/
    }
    public static void func(Object obj) {

    }
    public static void main3(String[] args) {
        func(new Money());  //匿名对象  缺点：每次使用都要new
        func(new Dog());
        func(new Animal());

        Dog dog = new Dog();
        dog.func1();
        dog.func3();
        System.out.println("==============");
        new Dog().func1();
        new Dog().func2();
        new Dog().func3();
    }
    public static void main2(String[] args) throws CloneNotSupportedException{
        Student student = new Student();
        Student student2 = (Student)student.clone();
        System.out.println(student.m.money);
        System.out.println(student2.m.money);
        System.out.println(student2.name);
        System.out.println("==============");
        student2.m.money = 99;
        System.out.println(student.m.money);
        System.out.println(student2.m.money);
    }
    public static void main1(String[] args) throws CloneNotSupportedException{
        Student student = new Student();
        student.name = "zhuguli";
        Student student2 = (Student)student.clone();
        System.out.println(student);
        System.out.println(student2);
    }
}
