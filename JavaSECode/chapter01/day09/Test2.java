package day09;

/**
 * ClassName: Test2
 * Package: day09
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/30 23:23
 * Version 1.0
 */
abstract class A {
    public int a;
    public int b;
 /*   public A() {

    }*/
    public A(int a,int b) {
        this.a = a;
        this.b = b;
    }
    public void func() {

    }
}
class B extends A {
    //父类有构造方法，这里默认有，不报错
    public B() {
        super(1,2);
    }
}
public class Test2 {
}
