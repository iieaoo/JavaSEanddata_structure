package user;

import book.BookList;
import opera.IOperation;

import java.awt.*;

/**
 * ClassName: User
 * Package: user
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:18
 * Version 1.0
 */
public abstract class User {
    protected String name;
    protected IOperation[] iOperations;

    public User(String name) {
        this.name = name;
    }
    abstract public int menu();

    public void doWork(int choice, BookList bookList) {
        this.iOperations[choice].work(bookList);
    }
}
