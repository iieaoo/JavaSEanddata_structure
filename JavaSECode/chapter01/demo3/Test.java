package demo3;

/**
 * ClassName: Test
 * Package: demo3
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/1 16:53
 * Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        IUSB iusb = new Mouse();
        computer.useDevice(iusb);   //向上类型转型
    }
    public static void main1(String[] args) {
        Computer computer = new Computer();
        Mouse mouse = new Mouse();
        KeyBoard keyBoard = new KeyBoard();
        computer.useDevice(mouse);
        System.out.println("============");
        computer.useDevice(keyBoard);
    }
}
