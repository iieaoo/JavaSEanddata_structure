package day10;

/**
 * ClassName: Test
 * Package: day10
 * Description:
 *  接口：可以看作是多个类的公共规范，是一种引用数据类型
 *    使用关键字interface来定义接口
 *    接口不能被实例化
 *    接口当中的成员 默认是public static final静态的常量
 *    接口当中不能有具体实现的方法，方法不写也是默认的public abstract
 *    但是JDK8开始可以写一个default修饰的方法
 *    接口当中不能有静态代码块和构造方法
 *    接口需要被类实现，使用关键字implements
 *    接口当中可以有static修饰的方法
 *    如果类没有实现接口中的所有抽象方法，则类必须设置为抽象类
 * 接口的命名一般以大写字母 I 开头， 一般使用“形容词”， 接口中的方法和属性不要加任何修饰符号，保持代码的简洁性
 *   重写的时候，子类的访问修饰权限一定要大于父类的访问权限
 * @Author 全家乐
 * @Create 2023/5/1 10:19
 * Version 1.0
 */
interface IShape {
    public String name = "ming";
    public static String name2 = "ming";
    public static final String name3 = "mm";
    void draw();
    default public void func() {
        System.out.println("默认的");
    }
    public static void staticFunc() {
        System.out.println("fsfsafa");
    }
}
class Rect implements IShape {

    @Override
    public void draw() {
        System.out.println("矩形！");
    }

    @Override
    public void func() {
        System.out.println("重写这个方法");
    }
}
class flower implements IShape {
    public void draw() {
        System.out.println("❀");
    }
}
public class Test {
    public static void drawMap(IShape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        IShape shape = new Rect();//向上转型
        IShape shape1 = new flower();
        drawMap(shape);
        drawMap(shape1);

        IShape.staticFunc();
    }
}
