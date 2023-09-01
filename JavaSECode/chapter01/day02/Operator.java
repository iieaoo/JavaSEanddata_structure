package day02;

/**
 * ClassName: Operator
 * Package: day02
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/19 19:55
 * Version 1.0
 */
public class Operator {
    public static void main1(String[] args) {
        System.out.println(5/2);
        System.out.println((float) 5/2);
        System.out.println(5/(float)2);
        System.out.println((float) (5/2));
    }

    public static void main2(String[] args) {
        System.out.println(10%3);
        System.out.println(10%-3);//除的时候商-3.余1
        System.out.println(-10%3);//商-3，余-1
        System.out.println(-10%-3);
        System.out.println(11.5%2);
    }

    public static void main3(String[] args) {
        int a = 10;
        a+=1;//a=a+1
        System.out.println(a);

        short sh = 12;
        //sh = sh+2; 强转，数据可能丢失
        sh += 2;//可以理解为半年给我们进行了类型的转换
        System.out.println(sh);
    }

    public static void main4(String[] args) {
        int a=10;
        int b=a++;//b=a   a+1
        System.out.println(a);
        System.out.println(b);
    }
    //左移相当于乘法
    //右移相当于除法
    //不存在无符号左移
    public static void main5(String[] args) {
        int a=12;
        System.out.println(a<<=3);
        System.out.println(a>>>=3);
        System.out.println((true == true) ? (true == true) ? false : true :true);//分层
    }

 /*   java中“\“是转义字符，如果想输出一个双引号，就要使用转义字符"\"
    如果想输出”\”使用转义字符“\\”*/
    public static void main6(String[] args) {
        System.out.println("\"hello\"");
        System.out.println("\\\"hello\\\"");
    }

   /* short 的取值范围是：【-32768 - 32767】
    byte 的取值范围是：【-128 - 127 】
    所以此时a的值可以正常存储进行打印为128，b的值最大存储127。
            128的二进制位1000 0000 存到byte类型的b中后就变成了-128*/
    public static void main7(String[] args) {
        short a =128;
        byte b =(byte) a;
        System.out.println(a);
        System.out.println(b);
    }

/*  long float double boolean 都不可以作为switch的参数
    switch 支持的类型有：char、byte、short、int、Character、Byte、Short、Integer、String、enum
    除了这些基本数据类型，后续说道的枚举，String也可以作为Switch的参数
    byte、char、short 类型在编译期默认提升为 int
    switch 支持 String 其实就是语法糖。编译器会根据字符串的 hashCode 来处理。*/
    public static void main(String[] args) {
        switch (2)
        {}
        switch ("abc")
        {}
    }
}
