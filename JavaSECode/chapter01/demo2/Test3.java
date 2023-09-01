package demo2;

/**
 * ClassName: Test3
 * Package: demo2
 * Description:
 * 注意：当在父类的构造方法当中去调用父类和子类重写的方法的时候，此时会调用子类的！
 * @Author 全家乐
 * @Create 2023/4/30 20:57
 * Version 1.0
 */
class B {
    public B() {
        //do nothing
        func(); //不要这样写
    }
    public void func() {
        System.out.println("B.func()");
    }
}
class C extends B {
    private int num = 1;
    public C() {
        super();
    }
    public void func() {
        //System.out.println("fafafafafa");
        System.out.println("C.func() " + num + "因为父类此时还没有走完");  //  num=0 父类的实例，父类的构造-》子类的实例-》子类的构造
    }
}
public class Test3 {
    public static void main(String[] args) {
        C c = new C();
    }
}

