package demo5;

import java.util.Arrays;

/**
 * ClassName: Test
 * Package: demo5
 * Description:
 *  comparable不灵活
 * @Author 全家乐
 * @Create 2023/5/2 11:59
 * Version 1.0
 */
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.name.compareTo(o.name) > 0) {  //string类型的方法
            return 1;
        }else if(this.name.compareTo(o.name) < 0) {
            return -1;
        }else {
            return 0;
        }
      /*  if (this.age > o.age) {
            return 1;
        }else if(this.age < o.age) {
            return -1;
        }else {
            return 0;
        }*/
    }
}
public class Test {
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
               /* if (array[j] > array[j+1]) {
                    交换；
                }*/
                if (array[j].compareTo(array[j+1]) > 0) {
                    Comparable temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Student[] student = new Student[3];
        student[0] = new Student("zhangsan",19,90);
        student[1] = new Student("Lisi",22,80);
        student[2] = new Student("Rose",21,97);

        System.out.println(student[0].compareTo(student[1]));
        Arrays.sort(student);
        System.out.println(Arrays.toString(student));
       /* Arrays.sort(student);   //  类型转换异常
        System.out.println(Arrays.toString(student));*/
    }
    public static void main1(String[] args) {
        int[] arr = {1,3,2,4,13,2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

