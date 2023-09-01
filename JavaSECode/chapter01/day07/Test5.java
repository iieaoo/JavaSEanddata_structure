package day07;

/**
 * ClassName: Test5
 * Package: day07
 * Description:
 *    在继承关系上。当我们在构造子类的时候，一定要先帮助父类进行构造
 *    super在子类构造方法内，调用父类构造方法时，一定要放在第一行
 *    执行时，父类》子类  静态大于》非静态
 *    静态的只执行一次
 *  private 修饰的成员变量或成员方法等，只能在当前类当中使用（被privat修饰的成员被继承了，但是不能访问）
 *  什么都不写（默认权限） 包访问权限，只能在当前包使用
 *  public 公开的，哪里都可以使用
 *  protected 受保护的 介于默认和公开之间，不同包的子类也可以用 不同包内访问，要用继承 通过super，不能直接用对象的引用调用
 *
 *  此时arr里的值不能改变，换句话说，arr这个引用指向的对象不能改变的
 * @Author 全家乐
 * @Create 2023/4/26 20:41
 * Version 1.0
 */
class Animals { //当一个类不想被继承的时候，前边可以加final，称为密封类
    public String name;
    public int age;
    public Animals() {
        System.out.println("Animals()");
    }
    static {
        System.out.println("Animals static{}");
    }

    {
        System.out.println("Animals {}");
    }

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("带有两个参数的构造方法！");
    }

    public void eat() {
        System.out.println(name + "正在吃饭！");
    }
}


class Dogs extends Animals {
    static {
        System.out.println("Dogs static{}");
    }
    {
        System.out.println("Dogs {}");
    }
    //一定放在第一行
    public Dogs() {
       // super("123",10);
        System.out.println("Dogs()");
    }
    public Dogs(String name, int age) {
       // super("Oct",10);    //显示的调用父类的构造方法，帮助父类的成员进行初始化
        super(name,age);
    }

    public void wangwang() {
        System.out.println(name + "wangwang!");
    }
}
class Cats extends Animals {
    public int size;
    public Cats(String name, int age, int size){
        super(name,age);    //放在上边，先帮助父类构造 ； 帮继承过来的父类进行初始化
        this.size = size;

    }
    //      super和this在调用方法时，不能同时出现
    public Cats(String name, int age) {
        //this("1,2,3");
            super("Sep",4);

    }

    public void mew() {
        System.out.println(name + "喵喵叫!");
    }
}
class Bird extends Animals {
    //父类有无参数的方法时，默认提供这样的构造方法
   /* public Bird() {
        super();
    }*/
}
public class Test5 {
    public static void main(String[] args) {
        final int A = 10; //不想修改，加final为常量，一般常量用大写，且要初始化
        //A = 100;
        System.out.println(A);
        final int[] arr = {1,2,3};
        //arr = new int[10];  //  此时arr里的值不能改变，换句话说，arr这个引用指向的对象不能改变的，但是可以改变对象的值
        arr[0] = 19;
    }
    public static void main2(String[] args) {
        Dogs dogs =new Dogs();
        System.out.println("================");
        Dogs dogs1 = new Dogs();    //第二次运行没有静态的，静态的只执行一次
    }
    public static void main1(String[] args) {
        Dogs dogs = new Dogs("pepper",10);
        dogs.name = "pepper";
        dogs.wangwang();
        System.out.println("==================");
        Cats cats = new Cats("1",2,3);
        cats.name = "mimi";
        cats.mew();
    }
}
