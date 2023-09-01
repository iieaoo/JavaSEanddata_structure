package day06;

/**
 * ClassName: DateUtil
 * Package: day06
 * Description:
 *      加上this表示给当前的对象赋值，谁调用这个方法，谁就是当前对象
 *      this访问构造方法
 *      this访问成员方法
 *      当我们调用完成 构造方法 对象就生成了
 *  1、为对象分配内存
 *  2、调用合适的构造方法
 *      this.data:访问当前对象的成员变量
 *      this.fun():访问当前对象的成员方法
 *      this():调用当前对象的其他构造方法
 * @Author 全家乐
 * @Create 2023/4/24 20:17
 * Version 1.0
 */
public class DateUtil {
    //成员变量：定义在方法外部 类的内部的变量
    public int year;
    public int month;
    public int day;

    //以下两个构造方法是重载的关系： （重载：方法名必须相同，参数列表不同，返回值没有影响）
    public DateUtil() {//构造方法，只会被调用一次，不能加void
        //构造方法中可以调用其他方法，简化代码
        this(1999,9,19);  // 必须放在第一行，只能在构造方法内部使用
        System.out.println("不带参数的构造方法，这个方法没有写，Java会默认提供一个不带参数的构造方法");
    }//如果自己写了，调用自己的
    public DateUtil(int year,int month,int day) {
        //this();循环调用error
        this.year = year;
        this.month = month;
        this.day = day;
        this.show();
        System.out.println("调用了带有3个参数的构造方法");
    }

    public static void main(String[] args) {
        //DateUtil dateUtil = new DateUtil(2023,4,24);
        DateUtil dateUtil = new DateUtil();
        dateUtil.show();
    }

    public void setDate(int year, int month,int day){
        //加上this表示给当前的对象赋值，谁调用这个方法，谁就是当前对象
        this.show();
        this.year = year;  //局部变量，优先使用
        this.month = month;
        this.day = day;
    }
    public void show() {
        System.out.println("年："+this.year+" 月："+ this.month + " 日：" + this.day);
    }

    public static void main1(String[] args) {
        //System.out.println(this.day);   error
        DateUtil dateUtil = new DateUtil();
        dateUtil.setDate(2023,4,24);
        dateUtil.show();

    }
}
