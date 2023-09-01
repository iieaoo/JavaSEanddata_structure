package demo3;

/**
 * ClassName: AddIndexOutOfException
 * Package: demo3
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/9 21:03
 * Version 1.0
 */
public class IndexOutOfException extends RuntimeException{
    public IndexOutOfException() {

    }
    public IndexOutOfException(String msg) {
        super(msg);
    }
}
