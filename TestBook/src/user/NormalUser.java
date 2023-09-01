package user;

import opera.*;

import java.util.Scanner;

/**
 * ClassName: NormalUser
 * Package: user
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:23
 * Version 1.0
 */
public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        this.iOperations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }
    public int menu() {
        System.out.println("*****************************");
        System.out.println("hello " + name + " 欢迎来到图书馆");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("*****************************");
        System.out.println("请输入你的操作：");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }
}
