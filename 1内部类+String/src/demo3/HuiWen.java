package demo3;

import java.util.Locale;
import java.util.concurrent.BlockingDeque;

/**
 * ClassName: HuiWen
 * Package: demo3
 * Description:
 *  验证回文字符，正反读一样
 *  遇到不有效的字符的时候，要一直加到有效的字符
 * @Author 全家乐
 * @Create 2023/5/5 17:02
 * Version 1.0
 */
public class HuiWen {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();    //转小写字母
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            while (left < right && !isValidChar(s.charAt(left))){
                left++;
            }//left是有效字符了

            while (left < right && !isValidChar(s.charAt(right))){
                right--;
            } //right是有效字符了

            if(s.charAt(left) != s.charAt(left)) {
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static boolean isValidChar(char ch) {
       /* Character.isDigit(ch); //确定字符是否位数字
        Character.isLetter(ch);//确定字符是否为字母*/
        if (Character.isDigit(ch) || Character.isLetter(ch)) {
            return true;
        }
        /*if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z') {
            return true;
        }*/
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abccba"));
    }
}
