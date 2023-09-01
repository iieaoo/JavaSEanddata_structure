package day07;

/**
 * ClassName: Test6
 * Package: day07
 * Description:
 *  super
 *      1、super.data 在子类中访问父类的成员变量
 *      2、super.func() 在子类中 访问父类的成员方法
 * @Author 全家乐
 * @Create 2023/4/26 20:48
 * Version 1.0
 */
class Base {
    public int a;
    public int b;
    public int c = 199;
    public void methodBase() {
        System.out.println("Base");
    }
}
class Derived extends Base {
    public int c = 9;

    public void methodDerived() {
        System.out.println("Derived");
    }
    public void methodBase(int a) {     //重载（重载可以不在同一个类里）
        System.out.println("Derived");
    }

    public void fun() {
        System.out.println(a);
        methodBase();
        super.methodBase();
        methodDerived();
    }
    public void fun1() {
        //子类有 就拿子类的 没有就用父类的
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(super.c);    //暂且理解为引用父类
    }
}
public class Test6 {
    public static void main(String[] args) {
        Derived derived = new Derived();
        System.out.println(derived.c);  //如果父类有和子类同名的成员变量，优先访问子类的
        derived.fun();
    }
}
