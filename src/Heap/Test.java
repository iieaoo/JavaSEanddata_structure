package Heap;

import javax.swing.*;
import java.util.*;

/**
 * ClassName: Test
 * Package: Heap
 * Description:堆的应用
 *   PriorityQueue（不安全） 放置的元素必须能够比较大小
 *   PriorityBlockingQueue(安全)
 *      默认小根堆
 *      排序 数量大就适合堆来解决
 * @Author 全家乐
 * @Create 2023/5/26 0:36
 * Version 1.0
 */
class Student implements Comparable<Student>{
    public int age;
    public String name;
    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
        //return o.age-this.age;//结果相反
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1,Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}


class Incmp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);//小根堆
    }
}
public class Test {
    public static void main(String[] args) {
        AgeComparator ageComparator = new AgeComparator();
        Queue<Student> priorityQueue2 = new PriorityQueue<>(ageComparator);
        priorityQueue2.offer(new Student("zhangsan",27));
        priorityQueue2.offer(new Student("lisi",15));;

        System.out.println("===========");

        /*Incmp incmp = new Incmp();
        Queue<Integer> priorityQueue1 = new PriorityQueue<>(incmp);*/

        /*Queue<Integer> priorityQueue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });*/
        Queue<Integer> priorityQueue1 = new PriorityQueue<>
                (((o1, o2) -> {return o2.compareTo(o1);}));//lambda表达式
        priorityQueue1.offer(1);
        priorityQueue1.offer(2);
    }
    public static void main4(String[] args) {
        Student student1 = new Student("zhangsan",10);
        Student student2 = new Student("lisi",20);
        System.out.println(student1 == student2);
        System.out.println(student1.equals(student2));

        System.out.println(student1.compareTo(student2));

        NameComparator nameComparator = new NameComparator();
        int ret1 = nameComparator.compare(student1,student2);
        System.out.println(ret1);

        AgeComparator ageComparator = new AgeComparator();
        int ret2 = ageComparator.compare(student1,student2);
        System.out.println(ret2);
    }

    //找前k个最小的元素
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];

        if (arr == null || k == 0) {
            return ret;
        }
        //O(N*logN)
        Queue<Integer> minHeap = new PriorityQueue<>(arr.length);
        for (int x : arr) {
            minHeap.offer(x);
        }
        //k * LOGN
        for (int i = 0; i < k; i++) {
            ret[i] = minHeap.poll();
        }
        return ret;
    }
    public static int[] maxestK(int[] arr, int k) {
        int[] ret = new int[k];
        if (arr == null || k == 0) {
            return ret;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        //遍历数组的前k个  放到堆当中
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }
        //2、遍历剩下的K-1个。每次和对顶元素进行比较
        for (int j = k; j < arr.length; j++) {
            int val = minHeap.peek();
            if (arr[j] > val) {
                minHeap.poll();
                minHeap.offer(arr[j]);
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = minHeap.poll();
        }
        return ret;
    }
    public static void main3(String[] args) {
        int[] arr = {1,5,43,3,2,7,98,41,56,78};
        int[] ret = maxestK(arr, 3);
        System.out.println(Arrays.toString(ret));
    }
    public static void main2(String[] args) {
        Queue<Integer> priorityQueue1 = new PriorityQueue<>();//默认小根堆
        priorityQueue1.offer(10);
        priorityQueue1.offer(2);

        System.out.println(priorityQueue1.poll());

        Queue<Student> priorityQueue2 = new PriorityQueue<>();
        priorityQueue2.offer(new Student("zhangsan",13));
        priorityQueue2.offer(new Student("lisi",23));
    }
    public static void main1(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        testHeap.initElem(array);
        testHeap.createHeap();
        System.out.println("================");
        //testHeap.offer(80);
        testHeap.pop();
    }
}
