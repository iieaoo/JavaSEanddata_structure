package opera;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * ClassName: FindOperation
 * Package: opera
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:34
 * Version 1.0
 */
public class FindOperation implements IOperation{
    public void work(BookList bookList) {
        System.out.println("查找图书！");
        System.out.println("请输入你要查找的书籍名称");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                System.out.println("找到了这本书：");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有这本书！");
    }
}
