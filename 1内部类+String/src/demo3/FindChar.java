package demo3;

import java.security.PublicKey;

/**
 * ClassName: FindChar
 * Package: demo3
 * Description:
 *    找字符串第一个不重复字符(只包含小写字母)
 * @Author 全家乐
 * @Create 2023/5/5 16:20
 * Version 1.0
 */
public  class FindChar {
    public static int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch-'a']++;//相对位置
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(count[ch - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "abccdca";
        System.out.println(firstUniqChar(str));
    }
}
