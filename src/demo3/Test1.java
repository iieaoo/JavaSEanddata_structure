package demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Test1
 * Package: demo3
 * Description:
 *  List  是一个接口，并不能直接用来实例化
 *  就是一个线性表，即n个具有相同类型元素的有限序列， 在该序列上可以执行增删改查以及变量等操作
 * @Author 全家乐
 * @Create 2023/5/9 19:53
 * Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);
    }
}
