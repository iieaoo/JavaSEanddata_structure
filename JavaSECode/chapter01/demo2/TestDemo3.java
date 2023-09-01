package demo2;

import demo1.TestDemo1;

/**
 * ClassName: TestDemo3
 * Package: demo2
 * Description:
 *  protected 不同包内访问，要用继承 通过super，不能直接用对象的引用调用
 * @Author 全家乐
 * @Create 2023/4/27 16:39
 * Version 1.0
 */
public class TestDemo3 extends TestDemo1 {
    public void fun() {
        System.out.println(super.a);    //静态方法里不能有super
    }
    public static void main(String[] args) {
        TestDemo1 testDemo1 = new TestDemo1();
        //System.out.println(testDemo1.a);
    }
}
