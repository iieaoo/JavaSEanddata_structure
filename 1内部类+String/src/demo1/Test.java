package demo1;

import jdk.nashorn.internal.IntDeque;
import sun.text.resources.cldr.es.FormatData_es_419;

/**
 * ClassName: Test
 * Package: demo1
 * Description:
 *  内部类；静态内部类（推荐）、非静态内部类
 *  匿名类
 * @Author 全家乐
 * @Create 2023/5/4 17:25
 * Version 1.0
 */
class OuterClass {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;
    //静态内步类
    static class InnerClass {
        public int data4= 4;
        private int data5 = 5;
        //此时当外部类加载的时候，这个非静态内部类不会加载
        public static int data6 = 6;

        public void func() {
            System.out.println("static->InnerClass::func()");
            //静态内部类当中 不能直接访问外部类的非静态成员
            OuterClass outerClass = new OuterClass();
            System.out.println(outerClass.data1);
            System.out.println(outerClass.data2);

            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
        }
    }
    public void test() {
        System.out.println("static->InnerClass::func()");
        //静态内部类当中 不能直接访问外部类的非静态成员
        OuterClass outerClass = new OuterClass();
        System.out.println(outerClass.data1);
        System.out.println(outerClass.data2);
        InnerClass innerClass = new InnerClass();
        System.out.println(innerClass.data4);
        System.out.println(innerClass.data5);   //外部类 可以访问静态内部类当中的所有成员
        System.out.println(InnerClass.data6);
    }
}

class OuterClass2 {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    //非静态内部类
    //在实例内部里 不能定义静态的成员变量
    class InnerClass2 {
        public int data1 = 111;
        public int data4 = 4;
        private int data5 = 5;
        //常量实在数据编译的时候，就能确定的final
        public static final int data6 = 6;

        public void func() {
            System.out.println("InnerClass::func()");
            System.out.println(data1);  //this.data1
            System.out.println("=" + OuterClass2.this.data1);//在非静态内部类当中，包含外部类的this的
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
        }
    }
    public void test() {
        InnerClass2 innerClass2 = new InnerClass2();
        System.out.println(data1);  //就近
        System.out.println(data2);
        System.out.println(data3);
        System.out.println(innerClass2.data4);
        System.out.println(innerClass2.data5);
        System.out.println(innerClass2.data6);
    }
}
class OutClass3 {
    public void func() {
        //只能在所定义的方法体内用
        class InnerClass {
            public int a = 1;
            public void test() {
                System.out.println("hello!");
            }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.test();
    }
}
interface IA {
    void func();
}
class AA implements IA {

    @Override
    public void func() {
        System.out.println("hello!!!");
    }
}
public class Test {
    public static void main(String[] args) {
        new IA() {
            //匿名类  一个类实现了这个接口，同时重写了func方法
            @Override
            public void func() {
                System.out.println("wwww");
            }
        }.func();
    }
    public static void main3(String[] args) {
        IA ia = new AA();
        ia.func();
    }
    /*
    实例内部类比较麻烦 需要外部类的对象
     */
    public static void main2(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        OuterClass2.InnerClass2 innerClass2 = outerClass2.new InnerClass2();
        innerClass2.func();
    }
    public static void main1(String[] args) {
        //实例化静态内部类的对象
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        innerClass.func();
    }
}
