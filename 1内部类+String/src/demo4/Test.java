package demo4;

import java.awt.*;
import java.util.Arrays;

/**
 * ClassName: Test
 * Package: demo4
 * Description:
 *  加static关键字的，表示当前成员变量是类的变量
 *  静态方法里不能使用非静态方法
 * @Author 全家乐
 * @Create 2023/5/6 15:02
 * Version 1.0
 */
class Car {
    //这个类是不能独立存在的
    class Engine {

    }
}
interface IA {
    void func();
}
public class Test {
    public static int[] func(int[] arr) {
        return new int[10];
    }

    public static void main(String[] args) {
        //匿名类  一个类实现了这个接口，同时重写了func方法
        //多用于接口的实现
        new IA() {
            @Override
            public void func() {
                System.out.println("====");
            }
        }.func();
    }

    public static void main3(String[] args) {
        Car car = new Car();
        Car.Engine engine = car.new Engine();
    }

    public static void main1(String[] args) {
        int[] ret = func(new int[]{1,2,3});
        int[] ret2 = {1,2,3};
        System.out.println(Arrays.toString(ret));   //返回的是一个新的对象
        System.out.println(Arrays.toString(ret2));
    }
    //普通成员变量
    public static void main2(String[] args) {
        CoolBoy boy = new CoolBoy();
    }

}

