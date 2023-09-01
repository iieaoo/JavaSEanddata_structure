package day05;

import java.util.Arrays;

/**
 * ClassName: HomeWork
 * Package: day05
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/22 20:06
 * Version 1.0
 */
public class HomeWork {
    public static double avg(int[] arr) {
        //实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
        int sum = 0;
        for (int x : arr) { //和下标没有关系； 数组类型 : 数组名)
            sum += x;
        }
        return (double)sum/(double)arr.length;
    }
    public static void main1(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(avg(arr));
    }
    public static int find(int[] array,int val) {
        //输出指定值的数组下标
        for (int i = 0; i < array.length;i++){
            if(array[i] == val) {
                return i;
            }
        }
        return -1;  //数组没有-1下标
    }

    public static void main2(String[] args) {
        int[] arr1 = {1,2,3,5};
        int ret = find(arr1,3);
        System.out.println(ret);
    }
    public static int sum (int[] array) {
        //实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
        int sum = 0;
        for (int x : array) {
            sum += x;
        }
        return sum;
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3};
        System.out.println(sum(array));
    }
    public static void printArr(int[] array) {
        for (int i = 0; i  < array.length; i++) {
            System.out.print(array[i]+", ");
        }
    }
    public static void main4(String[] args) {
        int[] arr = {1,2,3,4,5};
        printArr(arr);
    }
    public static void main5(String[] args) {
        //创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
        int[] array= new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i+1;
        }
        System.out.println(Arrays.toString(array));
    }
    public  static void bubbleSort(int[] array) {
        //最外层控制趟数
        for (int i = 0; i < array.length-1;i++) {
            boolean flag = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;    //  如果这趟已经排好序，不用进行后边几趟
                }
            }
            if (flag == false) {
                break;
            }
        }
    }
    public static void main6(String[] args) {
        int[] arr = {12,32,12,56,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr,32));
    }
    public static int[] findTarget(int[] array,int target) {
        int[] ret = {-1,-1};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; i < array.length; j++) {
                if (array[i] + array[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return new int[]{i,j};
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] array = {1,10,3,4,5};
        int[] ret = findTarget(array,6);
        System.out.println();
    }
}