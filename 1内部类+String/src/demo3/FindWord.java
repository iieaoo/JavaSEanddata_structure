package demo3;

/**
 * ClassName: FindWord
 * Package: demo3
 * Description:
 *  找单纯（不是空格的都是）
 * @Author 全家乐
 * @Create 2023/5/5 21:20
 * Version 1.0
 */
public class FindWord {
    public static int countSegment(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        String[] strings = s.split(" ");
        for (String x : strings) {
            if (x.length() != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "hollo   wsd wad ";
        System.out.println(countSegment(str));
    }
}
