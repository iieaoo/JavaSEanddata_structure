package demo3;

import java.util.Scanner;

/**
 * ClassName: LastCharLen
 * Package: demo3
 * Description:
 *  //字符串最后一个单词的长度
 * @Author 全家乐
 * @Create 2023/5/5 16:53
 * Version 1.0
 */
public class LastCharLen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int index = str.lastIndexOf(" ");
            String ret = str.substring(index+1);    //截取这之后的字符串
            System.out.print(ret.length());
        }
    }
}
