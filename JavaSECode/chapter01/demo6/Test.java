package demo6;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: Test
 * Package: demo6
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/2 13:06
 * Version 1.0
 */
/*class Student implements Comparable<Student>{
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
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
    @Override
    public int compareTo(Student o) {
        *//*if(this.age > o.age) {
            return 1;
        }else if (this.age < o.age) {
            return -1;
        }else {
            return 0;
        }*//*
        return this.age - o.age;
    }
}*/
class Student {
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
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}
class ScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.score - o2.score;
    }
}
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class Test {
    public static void main(String[] args) {
        Student[] student = new Student[3];
        student[0] = new Student("lisa",25,99);
        student[1] = new Student("Jennie",24,90);
        student[2] = new Student("Rose",26,95);

        //比较器
        AgeComparator ageComparator = new AgeComparator();
        ScoreComparator scoreComparator = new ScoreComparator();
        NameComparator nameComparator = new NameComparator();

        Arrays.sort(student,ageComparator);
        System.out.println(Arrays.toString(student));

        Arrays.sort(student,scoreComparator);
        System.out.println(Arrays.toString(student));

        Arrays.sort(student,nameComparator);
        System.out.println(Arrays.toString(student));
    }
    public static void main1(String[] args) {
        Student[] student = new Student[3];
        student[0] = new Student("lisa",25,99);
        student[1] = new Student("Jennie",24,90);
        student[2] = new Student("Rose",26,95);
        /*if (student[0].compareTo(student[1]) > 0) {
            System.out.println("student[0] > student[1]");
        }*/
        Arrays.sort(student);
        System.out.println(Arrays.toString(student));
    }
}
