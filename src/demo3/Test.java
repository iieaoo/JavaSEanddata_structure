package demo3;

import javax.swing.plaf.SpinnerUI;

/**
 * ClassName: Test
 * Package: demo3
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/9 20:36
 * Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.display();
        myArrayList.remove(2);
        myArrayList.display();
       /*try {
           myArrayList.add(1,99);
       }catch (IndexOutOfException e) {
           e.printStackTrace();;
       }
       try {
           System.out.println(myArrayList.get(1));
       }catch (IndexOutOfException e) {
           e.printStackTrace();
       }
       myArrayList.display();
       System.out.println("===========");
       myArrayList.get(0);*/
    }
}
