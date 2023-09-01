package demo4;

/**
 * ClassName: Test
 * Package: demo4
 * Description:
 *  一个类可以实现多个接口
 * @Author 全家乐
 * @Create 2023/5/1 22:50
 * Version 1.0
 */
abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
}
interface IRunnning {
    public void run();
}
interface ISwimming {
    void swim();
}
interface IFlying {
    void fly();
}
class Dog extends Animal implements IRunnning { //先继承，再实现
    public Dog(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(name + "正在用四条狗腿跑");
    }
}
class Fish extends Animal implements ISwimming{
    public Fish(String name) {
        super(name);
    }
    @Override
    public void swim() {
        System.out.println(name + "正在游泳！");
    }
}
class Bird extends Animal implements IFlying {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name + "正在飞!");
    }
}
class Duck extends Animal implements IFlying,ISwimming,IRunnning {  //  可以实现多个接口

    public Duck(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name + "正在用两条腿跑");
    }

    @Override
    public void swim() {
        System.out.println(name + "正在用两条腿游泳");
    }

    @Override
    public void fly() {
        System.out.println(name + "正在用翅膀飞");
    }
}
public class Test {
    /*
    只要实现了IRunning接口的 都可以接受（和是什么动物没关系）
     */
    public static void walk(IRunnning iRunnning) {
        iRunnning.run();
    }
    public static void swim(ISwimming iSwimming) {
        iSwimming.swim();
    }
    public static void func(Animal animal) {

    }
    public static void main(String[] args) {
        walk(new Dog("旺财"));
        walk(new Duck("tangtanng"));
        System.out.println("=============");
        swim(new Fish("qiqi"));
        swim(new Duck("tanglaoya"));
    }
}
