package demo3;

import java.util.Locale;

/**
 * ClassName: example
 * Package: demo3
 * Description:
 *  2016网易原题
 * @Author 全家乐
 * @Create 2023/5/5 17:32
 * Version 1.0
 */
public class Example {
    String str = new String("good");
    char[] ch = {'a','b','c'};

    public static void main1(String[] args) {
        Example ex = new Example();
        ex.change(ex.str , ex.ch);
        System.out.println(ex.str + " and ");
        System.out.println(ex.ch);
    }
    public void change(String str,char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }
    public static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin"; //产生了一个新对象，不是传值
    }

    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
}
