package demo2;

import java.lang.reflect.Array;

/**
 * ClassName: Test1
 * Package: demo2
 * Description:
 *  泛型： 适用于许多类型  对类型实现了一个参数化
 *  指定的参数必须是引用类型
 *  <T>表示占位符，表示当前类是一个泛型
 *      E: element   K: key   V: value   N: number   T: type    S,U,V等等: 第二、第三、第四个类型
 *  1、存储数据的时候，可以帮我们进行自动的类型检查（编译时候）
 *  2、获取元素的时候，可以帮我们进行类型的转换（编译的时候）
 * @Author 全家乐
 * @Create 2023/5/8 23:51
 * Version 1.0
 */
class MyArray<E> {  //代表当前类时一个泛型类 指定类型
    //public Object[] obj = new Object[3];
    //public T[] obj = new T[3];
    //public E[] obj = (E[]) new Object[3]; 不确定是什么类型
    public E[] obj;
    //public Object[] obj = new Object[3];

    public MyArray(Class<E> clazz, int capacity) {
        //反射
        obj = (E[]) Array.newInstance(clazz, capacity);
    }

    public E getPos(int pos) {
        return (E)obj[pos];
    }
    public void setPos(int pos, E val) {
        obj[pos] = val;
    }
    public E[] getArray() {
        return obj;
    }
}
public class Test1 {
    public static void main(String[] args) {
       // MyArray myArray = new MyArray();
        //实例化对象的同时 指定当前泛型列 的指定参数类型时Integer
        MyArray<Integer> myArray = new MyArray<Integer>(Integer.class,10);
        //就可以存储指定的类型
        myArray.setPos(0,10);
        myArray.setPos(1,78);
        myArray.setPos(2,66);
        /*
        此时存储数据的时候，什么数据都可以存储
        此时获取数据必须强转
        能不能指定放什么类型
         */
        int d =  myArray.getPos(2);  //不通用
        //Object d2 = myArray.getPos(2);  //掩耳盗铃 不能拿它用 忽略了他的实用意义
        Integer[] integers = myArray.getArray();

        System.out.println("==============");

  /*      MyArray<String> myArray1 = new MyArray<>();
        myArray1.setPos(0,"iieao");
        myArray1.setPos(1,"lisa");
        String str = myArray1.getPos(0);*/
    }
}
