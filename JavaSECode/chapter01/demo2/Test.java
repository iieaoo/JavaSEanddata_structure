package demo2;

/**
 * ClassName: Test
 * Package: demo2
 * Description:
 *  组合
 * @Author 全家乐
 * @Create 2023/4/27 17:30
 * Version 1.0
 */
class Student{

}
class Teacher {

}
class School {
    public Student[] students = new Student[3];
    public Teacher[] teachers = new Teacher[3];
}
public class Test {
    public static void main(String[] args) {
        School school = new School();
        Student[] students = new Student[3];
        students[0] = new Student();
    }
}
