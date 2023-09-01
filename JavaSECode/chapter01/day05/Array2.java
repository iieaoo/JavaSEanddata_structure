package day05;

import java.util.Arrays;

/**
 * ClassName: Array2
 * Package: day05
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/22 15:59
 * Version 1.0
 */
public class Array2 {
    public static void func1(int[] array) {
        array = new int[]{15,16,17};    //改变了形参的指向，比那个没有改变实参的执行
    }
    public static void func2(int[] array) {
        array[0] = 999; //此时传递的是 引用 ，我们通过这个引用修改了原来的值
    }
    public static  int[] func3() {
        int[] tempArr = {10,11,12}; //地址回收了，但值已经就收出来了
        return  tempArr;    //return了一个地址
    }
    public static void main(String[] args) {
        int[] array = func3();
        System.out.println(Arrays.toString(array));
        /*int[] array1 = {1,2,3,4};
        func1(array1);  //
        func2(array1);
        System.out.println(Arrays.toString(array1));*/
        /*
        通过其中任何一个引用修改这个对象的值，另一个引用去访问的时候，也是改变的，
        array1没人引用被系统回收
         */
     /*   int[] array1 = {1,2,3,4};
        array1[0] = 99;

        int[] array2 = array1;  //两个引用同时指向了一个对象
        array2[0] = 100;

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));*/
    }
}
