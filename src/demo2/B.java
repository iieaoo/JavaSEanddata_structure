package demo2;

/**
 * ClassName: A
 * Package: demo2
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/15 23:46
 * Version 1.0
 */
public class B <T>{
    private T value;

    public B(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        B<Integer> a = new B<Integer>(0);

        System.out.println(a.get());
        B<String> b = new B<String>("hello");

        System.out.println(b.get());
    }
}
