import book.Book;
import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * ClassName: Main
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:59
 * Version 1.0
 */

public class Main {
    public static User login()
            throws UserNameException,PassWordException {    //向上转型
        String name = "Admin";
        String password = "123456";

        System.out.println("请输入你的姓名：");
        Scanner sc = new Scanner(System.in);
        String name1 = sc.nextLine();
        System.out.println("请输入你的密码");
        String passWord1 = sc.nextLine();

        System.out.println("请输入你的身份：1->管理员 0->普通用户");

            if (!name1.equals(name)) {
                System.out.println("用户名错误！");
                throw new UserNameException();
            }
            if (!passWord1.equals(password)) {
                System.out.println("密码错误!");
                throw new PassWordException();
            }

        int choice = sc.nextInt();
        if (choice == 1) {
            return new AdminUser(name);
        }else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        try {
            login();
        }catch (UserNameException e) {
            e.printStackTrace();
        }catch (PassWordException e) {
            e.printStackTrace();
        }
        User user = login();
        while (true) {
            int choice = user.menu();
            //根据 choice 和 user 来确定到底调用哪个对象的操作
            BookList bookList = new BookList();
            user.doWork(choice, bookList);
            System.out.println("==============");
        }
    }
}
