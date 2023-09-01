package LinkedStorage;

import java.util.Scanner;

/**
 * ClassName: ContainChar
 * Package: LinkedStorage
 * Description:
 *  输入一个字符串，求该字符包含的字符集合，按照字母输入的顺序输出，只包含大小写字母，区分大小写
 * @Author 全家乐
 * @Create 2023/5/12 16:30
 * Version 1.0
 */
public class ContainChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String ret = func(str);
            System.out.println(ret);
        }
    }
    private static String func(String str) {
        boolean[] flg = new boolean[127];   //false
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (flg[ch] == false) { //说明没有出现过
                sb.append(ch);
                flg[ch] = true;
            }
        }
        return sb.toString();
    }
}
