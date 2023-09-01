package LinkedList;

import LinkedStorage.MysingleList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * ClassName: Test
 * Package: LinkedList
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/14 1:36
 * Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("hello");
        linkedList.add("ok");
        linkedList.add("fine");
        //遍历
        System.out.println(linkedList);
        System.out.println("=================");
        for (String x : linkedList) {
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("=================");
        ListIterator<String> it = linkedList.listIterator();//迭代器  专门用来遍历list
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();
        System.out.println("=================");
        ListIterator<String> it2 = linkedList.listIterator(linkedList.size());//迭代器  专门用来遍历list
        while (it2.hasPrevious()) {
            System.out.print(it2.previous()+" ");
        }

        ArrayList<String> list = new ArrayList<>();

        LinkedList<String> linkedList2 = new LinkedList<String>(list);
    }
    public static void main1(String[] args) {
        MysingleList mysingleList = new MysingleList();
        mysingleList.addFirst(1);
        mysingleList.addFirst(2);
        mysingleList.addFirst(3);
        mysingleList.addFirst(4);
        mysingleList.addFirst(5);
        mysingleList.display();
        mysingleList.addIndex(2,99);
        mysingleList.display();
        mysingleList.remove(3);
        mysingleList.display();
    }
}
