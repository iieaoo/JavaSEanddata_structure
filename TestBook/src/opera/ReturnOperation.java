package opera;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * ClassName: ReturnOperation
 * Package: opera
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:52
 * Version 1.0
 */
public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书！");
        System.out.println("输入你要归还的图书：");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name) && book.isBorrowed() == true) {
                book.setBorrowed(false);
                System.out.println("归还成功！");
                return;
            }
        }
    }
}
