package LinkedStorage;

import com.sun.scenario.effect.Merge;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: UnitArray
 * Package: LinkedStorage
 * Description:
 *  合并两个有序数组 变成一个有序的数组
 *      不能整体使用Arrays.sort方法
 *      不能申请额外的存储空间
 * @Author 全家乐
 * @Create 2023/5/12 17:12
 * Version 1.0
 */
public class UnitArray {
    public static void merge(int[] A,int m,int[] B,int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (i>=0 && j>=0) {//两个数组里都有数据
            if (A[i] <= B[j]) {
                A[k] = B[j];
                k--;
                j--;
            }else {
                A[k] = A[i];
                k--;
                i--;
            }
        }
        while (j >= 0) {
            A[k] = B[j];
            k--;
            j--;
        }
        System.out.println(Arrays.toString(A));
    }
    public static void main(String[] args) {
        int[] A = {3,4,5,0,0};
        int[] B = {1,2};
        merge(A,3,B,2);
    }
}
