package day05;

import java.util.Arrays;

/**
 * ClassName: fibo
 * Package: day05
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/22 17:22
 * Version 1.0
 */
public class fibo {
    public  static  int[] grow(int[] array) { //将数组每个元素扩大2倍
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i]*2;
        }
        return array;
    }
    public  static  void grow2(int[] array) { //将数组每个元素扩大2倍
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i]*2;
        }
    }
    public  static  int[] grow3(int[] array) { //java里可以是变量
        int[] tempArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i]*2;
        }
        return tempArray;
    }
    public static String myToString(int[] array) {
        if(array == null) {
            return "null";
        }
        String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
            if(i != array.length-1){
                ret += ",";
            }
        }
        ret = ret + "]";
        return ret;
    }
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
       /* grow(array);
        System.out.println(Arrays.toString(array));
        grow2(array);
        System.out.println(Arrays.toString(array));*/
       /* int[] ret = grow3(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(ret));*/

        System.out.println(myToString(array));
        System.out.println(myToString(null));
    }

    public static void main2(String[] args) {    //不叫拷贝还是一个数组对象
        int[] array = {1,2,3,4};
        System.out.println(Arrays.toString(array));
        int[] array2 = array;
        System.out.println(Arrays.toString(array2));
    }

    public static void main3(String[] args) {    //拷贝
        int[] array = {1,2,3,4};
        int[] array2 = new int [array.length];  //设置空间
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        System.out.println(Arrays.toString(array2));

        System.out.println("================");
        array2[0] = 199;
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        System.out.println("================");
        int[] ret = Arrays.copyOf(array,array.length*2);      //copy方法,可以扩容
        System.out.println(Arrays.toString(ret));

        int[] copy = new int[array.length]; //底层c++代码，快
       // System.arraycopy(array,0,copy,0,array.length);//从哪看，从数组哪里拷贝，拷贝到哪，拷贝到数组那个位置，拷贝多长
        System.arraycopy(array,1,copy,0,array.length-1);    //可以支持部分copy，指定区间
        System.out.println(Arrays.toString(copy));
        int[] ret2 = Arrays.copyOfRange(array,1,3);     //[1,3)
        System.out.println(Arrays.toString(ret2));
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4};
        int[] array2 = {1,2,3,4};
        int[] array4 = array1.clone();  //克隆就是生产一个副本
        System.out.println(Arrays.toString(array4));

        System.out.println(array1 == array2);   //false
        System.out.println(Arrays.equals(array1,array2));   //true

        int[] array3 = new int[10];
        Arrays.fill(array3,-1);
        System.out.println(Arrays.toString(array3));
    }
}
