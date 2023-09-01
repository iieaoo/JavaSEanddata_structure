package demo2;

/**
 * ClassName: Test2
 * Package: demo1
 * Description:
 *  装箱/装包       拆箱/拆包
 * @Author 全家乐
 * @Create 2023/5/7 15:39
 * Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b); //范围cache缓存数组【-128，127】 范围内指同一个数组地址    超出范围new对象
    }
    public static void main2(String[] args) {
        Integer val1 = 10;
        int a = val1; //拆箱-》  引用类型 拆箱为了 基本数据类型
        System.out.println(a);

        int b = val1.intValue();    //显示拆箱
        System.out.println(b);

        double d = val1.doubleValue();
    }
    public static void main1(String[] args) {
        int a = 10;
        //Integer val = a;    //自动装箱
        Integer val = Integer.valueOf(a);//显示装箱
        Integer val2 = new Integer(a);//显示装箱
        System.out.println(val);
    }
}
