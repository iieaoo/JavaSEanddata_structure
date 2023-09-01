package MapAndSet;

/**
 * ClassName: Test2
 * Package: MapAndSet
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/6/1 20:47
 * Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        char[] ch = new char[]{'a','b','c'};
        String s1 = new String(ch);
        //s1.intern();//加上就为true 把s1对象放到常量池
        String s2 = "abc";
        System.out.println(s1 == s2);//false
    }
}
