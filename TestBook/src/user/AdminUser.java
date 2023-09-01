package user;

import opera.*;

import java.util.Scanner;

/**
 * ClassName: AdminUser
 * Package: user
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:19
 * Version 1.0
 */
public class AdminUser extends User {
    public AdminUser(String name) {
        super(name);
        this.iOperations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new ShowOperation()
        };
    }

    public int menu() {
        System.out.println("*****************************");
        System.out.println("hello " + name + " 欢迎来到图书馆");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("*****************************");
        System.out.println("请输入你的操作：");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }
}
