/**
 * ClassName: HomeWork
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/7 0:27
 * Version 1.0
 */
class Base {
    Base() {
        System.out.print("Base");
    }
}

public class HomeWork extends Base{
    public static void main1(String[] args) {
        String str = "hello word";
        System.out.println(str.replace("l","$"));   //替换所有内容
        System.out.println(str.replaceFirst("l","@"));  //替换首个
    }

    public static void main2(String[] args) {
        String a = "abc";
        String b = "cba";
       // System.out.println(c.indexOf("b"));
        //System.out.println(c.contains("c"));
        System.out.println(a.compareTo(b));
    }


        public static void main( String[] args ) {
            new HomeWork();//1
            //调用父类无参的构造方法
            new Base();//2
        }
}
