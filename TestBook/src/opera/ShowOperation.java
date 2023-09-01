package opera;

import book.Book;
import book.BookList;

/**
 * ClassName: ShowOperation
 * Package: opera
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:38
 * Version 1.0
 */
public class ShowOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("打印所有图书！");
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize;i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }

}
