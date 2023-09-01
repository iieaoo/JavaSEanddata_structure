package book;

/**
 * ClassName: BookList
 * Package: book
 * Description:
 *     书架
 * @Author 全家乐
 * @Create 2023/5/3 20:12
 * Version 1.0
 */
public class BookList {
    private Book[] books = new Book[10];
    public BookList(){
        books[0] = new Book("三国演义","罗贯中",89,"小说");
        books[1] = new Book("西游记","吴承恩",79,"小说");
        books[2] = new Book("红楼梦","曹雪芹",49,"小说");
        this.usedSize = 3;
    }
    public Book getBook(int pos) {
        return this.books[pos];
    }

    public void setBook(Book book) {
        this.books[usedSize] = book;
    }
    public void setBook(int pos,Book book) {
        this.books[pos] = book;
    }

    private int usedSize;   //记录当前Books数组当中 有多少本书

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
