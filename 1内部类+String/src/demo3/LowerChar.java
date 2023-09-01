package demo3;

/**
 * ClassName: LowerChar
 * Package: demo3
 * Description:
 *  大写改小写
 * @Author 全家乐
 * @Create 2023/5/5 21:33
 * Version 1.0
 */
public class LowerChar {
    public static String toLowerCase(String s) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                char temp = (char) (ch+32);
                ret.append(temp);
            }else {
                ret.append(ch);
            }
        }
        return ret.toString();
    }
    public static String toLowerCase1(String s) {   // 效率低
        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                char temp = (char) (ch+32);
                ret += temp ;
            }else {
                ret += ch;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
    }
}
