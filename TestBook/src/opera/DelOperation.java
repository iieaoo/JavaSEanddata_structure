package opera;

import book.Book;
import book.BookList;

import javax.tools.Diagnostic;
import java.util.Scanner;

/**
 * ClassName: DelOperation
 * Package: opera
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:37
 * Version 1.0
 */
public class DelOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书！");
        System.out.println("请输入要删除图书的名称：");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int currentSize = bookList.getUsedSize();
        int index = -1;
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                index = i;
                break;
            }
        }
        for (int j = index; j < currentSize-1; j++){
            Book book = bookList.getBook(j+1);
            bookList.setBook(j,book);
        }

        bookList.setUsedSize(currentSize-1);
        //因为删除的是对象，所以把最后一个置为null
        bookList.setBook(currentSize-1,null);
        System.out.println("删除成功！");
    }
}
