package opera;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * ClassName: BorrowOperation
 * Package: opera
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:51
 * Version 1.0
 */
public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书！");
        System.out.println("输入你要借阅的图书：");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name) && !book.isBorrowed()) {
                book.setBorrowed(true);
                System.out.println("借阅成功！");
                return;
            }
        }
    }
}
