package day06;

import java.util.Arrays;

/**
 * ClassName: twoDimensionalArray
 * Package: day06
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/24 17:47
 * Version 1.0
 */
public class twoDimensionalArray {
    public static void main1(String[] args) {
        int[][] array = {{1,2,3},{4,5,6}};  //二维数组是特殊的一维数组
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println("===================");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===================");
        //方式二
        for (int[] ret : array) {
            for (int x : ret) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        System.out.println("===================");
        //方式三
        System.out.println(Arrays.deepToString(array)); //以字符串方式打印
    }

    public static void main(String[] args) {
        //不规则数组，没有列，可以指定列
        int[][] array = new int[2][];
        array[0] = new int[2];  //2列
        array[1] = new int[4];  // 4列
    /*    array[0] = new int[]{11,33,22};
        array[1] = new int[]{12,34};*/
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
