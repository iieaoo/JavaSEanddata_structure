package com.bite.www2;

/**
 * ClassName: TestDemo
 * Package: com.bite.www2
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/26 15:50
 * Version 1.0
 */
class C {
    int size2 = 999;

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo.size);
    }
}
public class TestDemo {
    int size = 99;  // 包访问权限，当前包使用
    public void show() {
        System.out.println(size);
    }

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.size2);
    }
}
