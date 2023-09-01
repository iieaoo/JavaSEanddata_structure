package opera;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * ClassName: AddOperation
 * Package: opera
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:34
 * Version 1.0
 */
public class AddOperation implements IOperation{
    public void work(BookList bookList) {
        System.out.println("新增图书！");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入书名：");
        String name = sc.nextLine();

        System.out.println("请输入作者：");
        String author = sc.nextLine();

        System.out.println("请输入类型：");
        String type = sc.nextLine();

        System.out.println("请输入价格：");
        int price = sc.nextInt();

        Book book = new Book(name,author,price,type);

        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book1 = bookList.getBook(i);
            if (book1.getName().equals(name)) {
                System.out.println("已经存入这本书了，不能再放入了！");
                return;
            }
        }

        bookList.setBook(book);
        //修改usedSize
        bookList.setUsedSize(currentSize+1);
    }
}
