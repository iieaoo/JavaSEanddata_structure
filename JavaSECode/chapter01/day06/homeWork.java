package day06;

import java.util.Arrays;

/**
 * ClassName: homeWork
 * Package: day06
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/24 14:16
 * Version 1.0
 */
public class homeWork {
    public static int binarySearch(int[] arr, int key, int low, int high) {
        //使用递归二分查找 (有序数组）
        if(key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] > key) {
            return binarySearch(arr,key,low,mid-1);
        }else  if(arr[mid] < key) {
            return binarySearch(arr,key,mid+1,high);
        }else {
            return mid;
        }
    }
    public static void main1(String[] args) {
        int[] arr = {1,2,3,4,7,8,9};
        System.out.println(binarySearch(arr, 3, 0, arr.length-1));
    }
    public static int comBinarySearch(int[] arr, int key) {
        //不用递归，二分查找有序数列
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        if (key < arr[low] || key > arr[high]) {
            return -1;
        }
        while (low <= high) {
            mid = (low + high) / 2;
            if(arr[mid] < key) {
                low = arr[mid] + 1;
            }else if (arr[mid] < key) {
                high = arr[mid] - 1;
            }else {
                return mid;
            }
        }
        return -1;  //没有找到，则返回-1
    }

    public static void main2(String[] args) {
        int[] arr = {1,2,3,4,5,7,8};
        System.out.println(comBinarySearch(arr,7));
    }
    public static String myToString(int[] arr) {
        //实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
        String a = "[";
        for (int i = 0; i < arr.length; i++) {
            a += arr[i];
            if (i != arr.length-1) {
                a += ",";
            }
        }
        a += "]";
        return a;
    }
    public static void main3(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(myToString(arr));

    }
    public static int[] findTarget(int[] array ,int target) {
        //给一个整数数组nums和一个目标值target,找出和为target的俩个数，返回它的下标
        int[] ret = {-1,-1};
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                   // return new int[]{i,j};
                }
            }
        }
        return ret;
    }
    public static void main4(String[] args) {
        int[] array = {1,10,3,4,5};
        int[] ret = findTarget(array,6);
        System.out.println(Arrays.toString(ret));
    }
    public static int findOnce(int[] arr) {
        //只出现一次的数字
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret ^= arr[i];//出现双次异或为0
        }
        return ret;
    }
    public static void main5(String[] args) {
        int[] arr = {1,1,2,3,4,4,3};
        System.out.println(findOnce(arr));
    }

    public static int majorityElement(int[] nums) {
        //出现超过次数大于L/2次
        Arrays.sort(nums);  //先排序
        return nums[nums.length/2];
    }
    public static int majorityElement2(int[] arr) {
        //出现超过次数大于L/2次
        int count = 0;  //投票
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {   //放上边，因为count为0了；
                count++;
                temp = arr[i];
            } else if (arr[i] == temp) {
                count++;
            }else if (arr[i] != temp) {
                count--;
            }
        }
        return temp;
    }
    public static void main6(String[] args) {
        int[] arr = {6,5,5};
        int ret = majorityElement2(arr);
        System.out.println(ret);
    }
    public static boolean fun(int[] arr) {
        //判断数组中是否连续三个元素都是奇数，是返回true
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 != 0) {
                count++;
                if (count == 3) {
                    return true;
                }
            }else {
                count = 0;
            }
        }
        return false;
    }
    public static void main7(String[] args) {
        int[] arr = {1,2,3,5,7};
        System.out.println(fun(arr));
    }
    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static  void reverse(int[] array) {
        //反转数组
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            swap(array,left,right);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}