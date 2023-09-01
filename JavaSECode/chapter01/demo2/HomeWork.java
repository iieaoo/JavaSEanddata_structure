package demo2;

import java.util.Arrays;

/**
 * ClassName: HomeWork
 * Package: demo2
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/27 17:52
 * Version 1.0
 */
class MyValue {
    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
public class HomeWork {
    public static void swap(MyValue myV1, MyValue myV2) {
        int temp = myV1.getVal();
        myV1.setVal(myV1.getVal());
        myV2.setVal(temp);
    }
    public static void main(String[] args) {
        MyValue myValue = new MyValue();
        myValue.setVal(10);
        MyValue myValue1 = new MyValue();
        myValue1.setVal(20);

        swap(myValue,myValue1);
        System.out.println(myValue.getVal());
        System.out.println(myValue1.getVal());
    }
    //给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
    public static int[] transfer(int[] a) {
        int left = 0;
        int right = a.length-1;
        if (left < right) {
            if (a[left] % 2 == 0) {
                left++;
            }
            if (a[right] % 2 != 0) {
                right--;
            }
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
        return a;
    }
    public static void swap1(int[] a, int[] b) {
        //给定两个整型数组, 交换两个数组的内容.
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            a[i] = b[i];
            b[i] = temp;
        }
        System.out.println("a:"+Arrays.toString(a));
        System.out.println("b:"+Arrays.toString(b));
    }
    public static void main1(String[] args) {
        /*int[] arr = {1,2,3,4,5};
        transfer(arr);
        System.out.println(Arrays.toString(arr));*/
        int[] a = {1,2,3};
        int[] b = {4,5,6};
        swap1(a,b);
    }
}
