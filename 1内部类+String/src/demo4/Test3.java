package demo4;

/**
 * ClassName: Test3
 * Package: demo4
 * Description:
 *  接口
 * @Author 全家乐
 * @Create 2023/5/6 18:32
 * Version 1.0
 */
interface IA1 {

}
class A implements IA1 {

}
class B implements IA1 {

}
public class Test3 {

    public static IA1 func() {
        //return new A();
        return new B();
    }

    public static void main(String[] args) {
        IA1 ia = new A();
        IA1 ia1 = new B();
        IA1[] ias = new IA1[]{new A(),new B()};
    }
}
