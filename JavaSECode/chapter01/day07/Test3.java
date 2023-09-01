package day07;

/**
 * ClassName: Test3
 * Package: day07
 * Description:
 * 成员变量：
 *  1、静态成员变量：不属于某个具体的对象，是所有对象所共享的
 *  2、非静态成员变量
 * 对静态成员变量的初始化
 *  1、直接赋值
 *  2、默认初始化
 *  3、可以通过提供get和set方法来进行初始化
 *  4、在构造对象时，可以在构造方法中进行赋值（不建议）
 *  5、通过代码块进行赋值：普通代码块、构造块、静态块、同步代码块(不建议)
 *      （顺序：静态代码块 》非静态代码块 》不带参数构造方法）
 * @Author 全家乐
 * @Create 2023/4/26 16:31
 * Version 1.0
 */
class Student1 {
    private String name;
    private int age;

    public static String classRoom = "107";   //上课的教室,

    //private static int size = 10;
    private static int size;

    public static int getSize() {//  建议 获取静态的成员变量或者是设置静态的成员变量，
        return size;
    }
    public static void setSize(int size) {
        Student1.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("2个参数的构造方法");
    }

    {
        name = "jennie";
        System.out.println("非静态代码块/实例代码块/构造代码块！-> 初始化非静态的数据成员");//执行构造方法前先执行它,所以这里赋值不算
    }

    static {    //  静态代码块
        System.out.println("静态代码块-》初始化静态的数据成员 / 提前准备一些数据");
    }

    public Student1(String name, int age,int si) {
        this.name = name;
        this.age = age;
        size = si;  //  不建议
    }
    public Student1() {
        System.out.println("不带参数的构造方法");
    }
    public void doClass() {
        fun();
        System.out.println(name + "上课！");
    }

    public static void fun() {
      /*  System.out.println(this.name);    //静态方法中不能 直接 使用非静态的数据成员
        System.out.println(name);*/
        Student1 student1 = new Student1("baby",18);
        System.out.println("staticFun()");
        {
            //这块代码的执行不需要条件
            System.out.println("定义在方法内部的代码块：普通代码块！");
        }
    }
}
public class Test3 {
    public static void main(String[] args) {
        //只要这个类被加载 静态代码块 都会被执行
        Student1.fun();
        Student1.fun();
    }
    public static void main3(String[] args) {
        //Student1 student1 = new Student1("lisa",25);
        Student1 student1 = new Student1();
        //System.out.println(student1.getName());
    }
    public static void main2(String[] args) {
        Student1 student1 = new Student1("lisi",10,9);
        System.out.println(Student1.getSize());
        Student1.fun();
    }
    public static void main1(String[] args) {
        Student1 student1 = new Student1("lisi",10);
        Student1 student2 = new Student1("lisi",10);
        Student1 student3 = new Student1("lisi",10);
        //System.out.println(student1.classRoom);
        System.out.println(Student1.classRoom); // 静态的成员变量不属于对象，不用通过对象的引用访问，直接通过类名访问就可以访问
        student1.doClass();
        student1.fun();
        Student1.fun(); //  静态成员方法不依赖对象
        System.out.println("s");
        System.out.println(Student1.getSize());
    }
}
