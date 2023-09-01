package demo3;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

/**
 * ClassName: CvteTest
 * Package: demo3
 * Description:
 *  s1:"welcome to bit"
 *  s2:"come"
 *  要求删掉s1中s2出现的字符
 * @Author 全家乐
 * @Create 2023/5/11 15:35
 * Version 1.0
 */
public class CvteTest {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        String s1 = "welcome to bit";
        String s2 = "come";

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (!s2.contains(ch+"")) {
                list.add(ch);
            }
        }
        //System.out.println(list);

        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j));
        }
    }
}
