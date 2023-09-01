package day01;

/**
 * ClassName: HelloWord
 * Package: day01
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/17 19:24
 * Version 1.0
 */
public class HelloWord {
    //main psvm
    public static void main(String[] args) {
        int a=10;
        //sout
        System.out.println(a);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        //ctr+shift+"/"

        double num = 1.1;
        System.out.println(num * num);//小数没有精确的 只能说 精确到某个位

        float f = 12.5f;//加f ,12.5超出范围,为double类型，如果不声明，小数默认是double类型
        System.out.println(f);
        /*包装类型：
        是基本数据类型对应的 类类型 ——专业术语
        是基本数据类型的加大版本，他具备的功能比较多。有了他可以提供很多方法让我们使用
         */
        char ch ='a';//两个字节，
        System.out.println(ch);
        char ch2 = '美';
        System.out.println(ch2);
        char ch3 = 97;//unicode  a->97 A->65 0-?48
        System.out.println(ch3);

        //没有人知道boolean大小0是假 非0 为真。在java当中，真只有一个true 假为false，不能和整数混合运算
        boolean flg = true;
    }

    public static void main2(String[] args) {
        /*
        类型转换
         */
        int a = 10;
        long b = 20L;
        b=a;    //int->long,数值范围由小到大，隐式转换
        a=(int)b;   //long->int,大到小，强制转换

        float f = 3.14F;
        double d=5.12;
        d=f;
        f=(float) d;

        a=(int) d;

        byte b1=100;
        byte b2=(byte) 256;
    }
    /*
    总结：8种数据类型：
        byte 1个字节、short 2、int 4、long 8【整型】
        float 4、double 8【浮点型】
        char 2【字符类型】
        boolean【布尔类型】
        对应的有包装类->int->Integer char->Character
        Java当中直接赋值不能超过这个数据类型所能表达的最大范围
     */
}
