package day05;

/**
 * ClassName: Array
 * Package: day05
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/22 0:21
 * Version 1.0
 */
public class Array {
    public static void main1(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6};
        int[] array3 = new int[10];
        int[] array4;
        array4 = new int[]{1, 2, 3, 4, 5, 6};
        /*
        int[] array;
        array = {1,2,3}; //不可以实现;如果省略new int[]必须一行写完
         */
    }

    public static void main2(String[] args) {
        boolean[] array = new boolean[10];//false
        char[] array2 = new char[10];//'u0000'
        System.out.println("====");
        String str = new String("hello");
        String str1 = "hello";
    }

    public static void findnum(int[] array) {
        //有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            int j = 0;
            for (; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
                if (count == 2) {
                    break;
                }
            }
            if (j == array.length) {
                System.out.println(array[i] + ", 下标是:" + i);
            }
        }
    }

    public static void sort(int[] array) {
       /* 调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
        如数组：[1,2,3,4,5,6]
        调整后可能是：[1, 5, 3, 4, 2, 6]*/
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
               if(array[i] % 2 == 0) {
                   int temp = array[i];
                   array[i] = array[j];
                   array[j] = temp;
               }
            }
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args) {
  /*      int[] array = {1,12,93,42,5,6};
        array[0] = 99;
        System.out.println(array[0]);   //下标0~5
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {    //通过下标遍历
            System.out.println(array[i]);
        }
        System.out.println("============");
        for(int x : array) {    //和下标没有关系； 数组类型 : 数组名
            System.out.println(x);
        }
        System.out.println("============");
        Arrays.sort(array); //数组排序*/

  /*      String ret = Arrays.toString(array);
        System.out.println(ret);*/
        int[] array = {1,2,4,3,3,2,6,6};
        //findnum(array)
        sort(array);
    }
}
