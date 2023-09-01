package day09;

/**
 * ClassName: Test
 * Package: day09
 * Description:
 * 抽象类
 *   抽象类不能被实例化
 *   此时在抽象类当中，可以有抽象方法（被abstract修饰，没有具体的实现，包含抽象方法必须是一个抽象类），或者非抽象方法
 *   当一个普通类继承了这个抽象类，必须从重写抽象类的抽象方法
 *   抽象类最大的意义就是被继承,相当于多了一重编译器的检验
 * 抽象类与普通类区别：
 *    抽象类不能被实例化
 *    抽象类可以包含抽象方法和抽象方法
 *    抽象方法不能是private，final，static，所以一定要满足重写的规则
 *    当一个子类没有被重写抽象类的父类的方法，可以把当前子类变为abstract修饰
 * @Author 全家乐
 * @Create 2023/4/30 22:14
 * Version 1.0
 */
abstract class Shape {
    public abstract void draw();
    public void fun() {

    }
}
class Rect extends Shape {  //Rect后alt+回车 implement
    @Override
    public void draw() {

    }
    /*public void draw() {
        System.out.println("画矩形");
    }*/
}
class Cycle extends Shape {
    public void draw() {
        System.out.println("画圆形");
    }
}
public class Test {
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
       // Shape shape = new Shape();  // error 抽象类不能被实例化
        drawMap(new Rect());
        drawMap(new Cycle());

        Shape shape = new Cycle();
    }
}
