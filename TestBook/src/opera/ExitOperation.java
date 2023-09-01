package opera;

import book.BookList;

/**
 * ClassName: ExitOperation
 * Package: opera
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/3 20:40
 * Version 1.0
 */
public class ExitOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("推出系统！");
        System.exit(0);
    }
}
