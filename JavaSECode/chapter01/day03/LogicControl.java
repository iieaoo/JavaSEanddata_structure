package day03;

import java.util.Scanner;

/**
 * ClassName: LogicControl
 * Package: day03
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/20 16:54
 * Version 1.0
 */
public class LogicControl {
    //编写程序数一下 1到 100 的所有整数中出现多少个数字9
    public static void main1(String[] args) {
       /* int count = 0;
        for(int i=1;i <= 100;i++){
            if(i == 9) {
                count++;
            }else if(i % 10 == 9){
                count++;
                continue;
            }else if(i/10%10 == 9) {
                count++;
            }
        }
        System.out.println(count);*/
        int count = 0;
        for(int i=1;i<=100;i++){
            if(i/10 == 9 || i%10 == 9){
                count++;
            }
        }
        System.out.println(count);
    }

    //判断一个年份是否为闰年
    public static void main2(String[] args) {
        int year=2023;
        if(year%100 == 0){  //世纪闰年
            if(year % 400 == 0){
                System.out.println("是闰年");
            }else{
                System.out.println("不是闰年");
            }
        }else{  //普通闰年
            if(year % 4 == 0){
                System.out.println("是闰年");
            }else{
                System.out.println("不是闰年");
            }
        }
    }
    public static void main3(String[] args) {
        int year = 2000;
        if(year % 100 == 0 && year % 400 == 0 || year % 100 != 0 && year % 4 == 0) { //year%100 == 0可以省略
            System.out.println(year+"是闰年");
        }else{
            System.out.println(year+"不是闰年");
        }
    }
    //输出 1000 - 2000 之间所有的闰年
    public static void main4(String[] args) {
        for(int i=1000;i<=2000;i++){
            if(i % 400 == 0 || i / 100 != 0 && i % 4 == 0){
                System.out.println(i);
            }
        }
    }
    //打印 1 - 100 之间所有的素数
    public static void main5(String[] args) {
            int count = 0;
            for(int i=2;i<=100;i++){
            boolean flag = true;
            for (int j=2;j<=i/ Math.sqrt(i);j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
                System.out.print(i+" ");
            }
        }
            System.out.println();
            System.out.println(count);
    }
        //判定素数
        public static void main6(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            if(a==1) {
                System.out.println("1不是素数");
            }
            for(int i=2;i<=a;i++) {
                for(int j=2;j<=Math.sqrt(a);j++){
                    if(i % j == 0) {
                        break;
                    }
                }
                if(i == a){
                    System.out.print(a+"是素数");
                 }
            }
        }
        //根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        public static void main7(String[] args) {
            Scanner sc = new Scanner(System.in);
            int age = sc.nextInt();
            if(age>=0 && age<=18){
                System.out.println("当前年龄的人是少年");
            }else if(age>=19 && age<=28){
                System.out.println("当前年龄的人是青年");
            }else{
                System.out.println("当前年龄的人是老年");
            }
        }
        //找1-100既能被3整除，又能被5整除的数
        public static void main8(String[] args) {
            for(int i=1;i<=100;i++) {
                if(i % 3 == 0 && i % 5 ==0){    //i%15 == 0
                    System.out.print(i+" ");
                    continue;
                }
            }
        }

    public static void main9(String[] args) {
        Scanner sc =new Scanner(System.in);
        /*如果把年龄在姓名前，年龄读完程序结束，因为nextLine会把上边的读取到
            如果要放在前边，在年龄后加sc.nextLine();*/
        System.out.println("请输入你的年龄");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("请输入你的姓名");
        String name = sc.nextLine();
        System.out.println("请输入你的工资");
        float salary = sc.nextFloat();
        System.out.println("你的信息如下：");
        System.out.println("姓名："+name+"\n"+"年龄"+age+"\n"+"工资"+salary);

        sc.close(); //注意调用关闭方法
    }

    public static void main10(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println("n="+n); //ctrl+d;cmd:ctrl+n
        }
    }

    public static void main11(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                if (i==j || i+j==a+1) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
