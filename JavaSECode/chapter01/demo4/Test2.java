package demo4;

/**
 * ClassName: Test2
 * Package: demo4
 * Description:
 *  类可以实现一个普通类/抽象类 同时 实现多个接口
 *  接口可以通过extends 拓展多个接口的功能
 * @Author 全家乐
 * @Create 2023/5/2 11:03
 * Version 1.0
 */
interface A {
    void funcA();
}
interface B {
    void funcB();
}
//CC这个接口 不仅具备func这个功能，还具备A，B接口的功能
interface CC extends A,B {
    void funcC();
}
class C implements CC {
    public void funcA() {

    }
    public void funcB() {

    }
    public void funcC() {

    }
}
public class Test2 {
}
