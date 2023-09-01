package demo3;

/**
 * ClassName: KeyBoard
 * Package: day10
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/1 16:19
 * Version 1.0
 */
public class KeyBoard implements IUSB {
    @Override
    public void openDevice() {
        System.out.println("打开键盘！");
    }

    @Override
    public void closeDevice() {
        System.out.println("关闭键盘！");
    }
    public void inPut() {
        System.out.println("键盘输入！");
    }
}
