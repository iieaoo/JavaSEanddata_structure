package demo3;

/**
 * ClassName: Computer
 * Package: demo3
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/1 16:32
 * Version 1.0
 */
public class Computer {
    public void open() {
        System.out.println("开机");
    }
    public void close() {
        System.out.println("关机");
    }

    //所有的USB设备 在电脑上是不是都可以使用
    public void useDevice(IUSB usb) {
        usb.openDevice();
        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse)usb;
            mouse.click();  //向下转移
        }else if (usb instanceof KeyBoard) {
            KeyBoard keyBoard = (KeyBoard)usb;
            keyBoard.inPut();
        }
        usb.closeDevice();
    }
}
