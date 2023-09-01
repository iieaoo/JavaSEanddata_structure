package day07;

/**
 * ClassName: Test4
 * Package: day07
 * Description:
 *  继承: 对代码可以进行复用 , 只能继承一个类
 * @Author 全家乐
 * @Create 2023/4/26 19:54
 * Version 1.0
 */
class Animal {
    public String name;
    public int age;

    public void eat() {
        System.out.println(name+"正在吃饭！");
    }
}
class Dog extends Animal{
    public int count;
    public void bark() {
        System.out.println(name + "正在叫!");
    }
}

class Cat extends Animal{
    public void miaomiao() {
        System.out.println(name + "正在喵喵叫!");
    }
}
public class Test4 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "lucky";
        dog.eat();
        dog.bark();
        Cat cat = new Cat();
        cat.name = "pepper";
        cat.eat();
        cat.miaomiao();
    }
}

