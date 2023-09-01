package demo4;

/**
 * ClassName: Test2
 * Package: demo4
 * Description:
 *    继承是共性的抽取，从而达到对代码的复用
 *  子类继承了父类的什么：  所有成员变量和方法都被继承了【非静态的】
 *    访问修饰限定符：
 *          private
 *          默认权限-包访问权限
 *          protected-同包和不同包子类
 *          public-通用
 *       final修饰变量 常量 不能修改
 *            修改成员方法  不能被重写
 *            修饰类   不能被继承
 *   多态：  向上转型
 *          通过父类的引用 调用父类和子类重写的方法
 *          向下转型（不安全，不建议使用）  一定要用关键字instanceof 进行判断
 *   抽象类 可以包含抽象方法和非抽象方法
 *         和普通类唯一的区别是不能被实例化，且多了一个抽象方法，这个抽象方法还可以不写
 *         当一个类继承这个抽象类之后，必须重写这个抽象类的抽象方法
 *   接口  成员变量默认是 public static final
 *         成员方法默认 public abstract
 *   异常  抛出异常后，后面的内容不能打印
 *   编译时异常/受查异常 和 运行时异常/非受查异常
 *   抛出异常主要的5个关键字：throw try catch final throws
 * @Author 全家乐
 * @Create 2023/5/6 16:47
 * Version 1.0
 */

class Animal {
    public String name;
    public int age;

    public void eat() {

    }
}
class Cat extends Animal {
    //同名情况下，this优先访问的就是自己的
    //父类静态（只执行一次）-》子类静态-》父类实例和构造-》子类实例和构造
    public String color;
    @Override
    public void eat() {
        System.out.println(name + "正在吃猫粮！");
    }
}
class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println(name + "正在吃狗粮！");
    }
}
public class Test2 {
    public static void func1(Animal animal) {
        animal.eat();
    }
    //这个可以返回子类对象 或者类自己本身的对象
    public static Animal func2() {
        //return new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();
        return cat;//利用了方法的返回值，向上转型
    }

    public static void main(String[] args) {

    }
    public static void main2(String[] args) {
        Animal cat = new Cat();    //传参
        Dog dog = new Dog();
        func1(cat);
        func1(dog);
    }
    public static void main1(String[] args) {
        Animal animal = new Cat();//编译的时候调用父类的 运行调用子类的 动态绑定
        animal.eat();   //掉用子类的eat方法
        //animal.color;  error 向上转型确定：只能通过父类方法 调用父类和子类重写的方法
    }
}
