package demo3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * ClassName: Test2
 * Package: demo3
 * Description:
 *  在第一次add的时候 才会为ArrayList底层的elementData分配内存，且大小为10 超过11，扩容1.5倍o
 * @Author 全家乐
 * @Create 2023/5/10 21:00
 * Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

        List<Integer> sub = list.subList(1,3);//[1,3)  截取
        System.out.println(sub);

        System.out.println("===================");

       /*遍历方式三
       ListIterator<Integer> it = list.listIterator(); //迭代器
        while (it.hasNext()) {  //打印的同时，让it走一步
            System.out.println(it.next()+" ");
        }*/

        /*遍历方式三
        for (Integer x : list) {
            System.out.println(x+ " ");
        }*/

      /* 遍历方式二
      for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/

       /*遍历方式一
       sub.set(0,99);
        System.out.println(sub);
        System.out.println(list);   //list也会变 他们公用1个elemDate数组*/

        /*ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);

        arrayList.add(0,10);

        arrayList.remove(new Integer(10));

        arrayList.get(0);

        arrayList.clear();

        System.out.println(arrayList);*/
    }
}
