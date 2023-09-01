package demo3;

/**
 * ClassName: BufferBuilder
 * Package: demo3
 * Description:
 *  string不可变
 *      StringBuffer StringBuilder是可修改的
 *      StringBUffer 和 StringBuilder 大部分功能是相似的
 *      StringBuffer(适合多线程)采用同步处理，属于线程安全操作（锁）；而StringBuilder未采用同步处理，属于线程不安全操作（频繁的加锁和解锁都需要耗费资源）
 *  常量池：1、双引号引起来的 统一放到常量池
 *        2、如果常量池有 那么 就不再额外存储
 * @Author 全家乐
 * @Create 2023/5/5 15:36
 * Version 1.0
 */
public class BufferBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("abc");
        StringBuffer stringBuffer = new StringBuffer("abc");
        System.out.println(stringBuilder);

        stringBuilder.append("123").append(10);
        stringBuilder.append(19.9);
        System.out.println(stringBuilder);  //此时不会产生临时对象

        String ret = stringBuilder.toString();  //把stringBuilder变成字符串对象

/*        stringBuilder.reverse();    //字符串逆置
        System.out.println(stringBuilder);*/

    }
    public static void main2(String[] args) {
        String str = "hello";
        long start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(i);
            // stringBuilder.append("abc");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);    //10
        // str = stringBuilder.toString();
        // System.out.println(str);
    }
    public static void main1(String[] args) {
        long start = System.currentTimeMillis();
        String str = "hello";
        //不建议在循环中使用 + 对字符串进行拼接。每循环一次会创建一次临时对象
        for (int i = 0; i < 10000; i++){
            str += "abc";
        }
        long end = System.currentTimeMillis();
        //  System.out.println(str);
        System.out.println(end - start);    //320
    }
}
