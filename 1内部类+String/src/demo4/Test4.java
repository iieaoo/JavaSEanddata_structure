package demo4;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * ClassName: Test4
 * Package: demo4
 * Description:
 *  异常  抛出异常后，后面的内容不能打印
 *  编译时异常/受查异常 和 运行时异常/非受查异常
 *  抛出异常主要的5个关键字：throw try catch final throws
 *  throw 抛出一个异常   throws声明一个异常
 *  当我们没有解决这个问题时，我们就会把这个异常交给JVM ，一旦交给JVM 程序就出错了
 *  可以通过“，”抛出多个异常
 *  catch (Exception e)  写最后
 *  当try中存在多个异常时，从上往下执行，谁先抛出异常，就捕获哪个异常
 *  在同一时间只会抛出一个异常
 *  不管是否在try中抛出执行 finally都会执行  finally一般用于资源的释放
 * 顺序：
 *      1、程序先执行try中代码
 *      2、如果try中的代码出现异常，就会结束try中的代码，看和catch中的异常类型是否匹配
 *      3、如果找到匹配的异常类型，就会执行catch中的代码
 *      4、如果没有找到匹配的异常类型，就会将异常向上传递到上层调用者
 *      5、无论是否找到匹配的异常类型，finally中的代码都会被执行到
 *      6、如果上层调用者也没有处理的了异常 ，就继续向上传递
 *      7、一直到main方法也没有合适的代码处理异常，就会交给jvm来处理，此时程序就会异常终止
 * @Author 全家乐
 * @Create 2023/5/6 20:14
 * Version 1.0
 */
class Person implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException,NullPointerException {
        return super.clone();
    }
}
public class Test4 {
    public static void test1(int[] a) throws CloneNotSupportedException {
        if (a == null) {
            throw new CloneNotSupportedException();   //被中断了
            //throw new NullPointerException();//一般用在自己自定义异常
        }
    }

    public static int test2() {
        try {
            int a = 10;
            return a;
        }catch (NullPointerException e) {
            return 1;
        }finally {
            return 9;   //不建议在finally里 写return语句
        }
    }

    public static void main(String[] args) {
        System.out.println(test2());
    }
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            //当try中存在多个异常时，从上往下执行，谁先抛出异常，就捕获哪个异常
            int[] arr = null;
            System.out.println(arr[10]);
            System.out.println("after");

            System.out.println(10/0);
        }catch (ArithmeticException e) {
            System.out.println("捕捉到了ArithmeticExceptionn异常 ,进行处理异常的逻辑");
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("捕获到了NullPointerException异常");
        }catch (Exception e) { //对于受查异常来说，当try当中没有抛出catch这个受查异常的时候 这里检测不到就会报错
            e.printStackTrace();
            System.out.println("捕捉到了Exceptionn异常 ,进行处理异常的逻辑");
        }finally {
            sc.close();
            //JDBC con.close
            System.out.println("finally....");
        }
        System.out.println("正常的逻辑");
    }
    public static void main3(String[] args) {
        try {
            int[] arr = null;
            System.out.println(arr.length);
            System.out.println("after");
        }catch (ArithmeticException | NullPointerException e) { //缺点：不能指定到底哪里有问题
            e.printStackTrace();
            System.out.println("捕捉到了ArithmeticExceptionn | NullPointerException 异常 ,进行处理异常的逻辑");
        }
        System.out.println("正常的逻辑");
    }
    public static void main2(String[] args) {;
        try {
            //存放可能抛出异常的代码
            //test1(null);
            int[] arr = null;
            System.out.println(arr.length);
            System.out.println("after");
        }catch (ArithmeticException e) { //对于受查异常来说，当try当中没有抛出catch这个受查异常的时候 这里检测不到就会报错
            e.printStackTrace();
            System.out.println("捕捉到了ArithmeticExceptionn异常 ,进行处理异常的逻辑");
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("捕获到了NullPointerException异常");
        }

        System.out.println("正常的逻辑");
    }
    public static void main1(String[] args)throws Exception {    //编译时异常
        Person person = new Person();
        Person person1 = (Person) person.clone();
    }
}
