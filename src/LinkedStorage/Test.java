package LinkedStorage;

import java.util.HashMap;

/**
 * ClassName: Test
 * Package: LinkedStorage
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/11 19:39
 * Version 1.0
 */
public class Test {
    //输入两个链表，找出他们的公共结点
    public static MysingleList.ListNode getIntersectionNode(MysingleList.ListNode headA, MysingleList.ListNode headB) {
        //分别求两个链表的长度
       if (headA == null && headB == null) {
           return null;
       }
       //分别求两个链表的长度
        int lenA = 0;
        int lenB = 0;
        MysingleList.ListNode pl = headA;
        MysingleList.ListNode ps = headB;

        while (pl != null) {
            lenA++;
            pl = pl.next;
        }
        while (ps != null) {
            lenB++;
            ps = ps.next;
        }
        //要指回来
        pl = headA;
        ps = headB;
        int len = lenA- lenB;//大小
        //3、根据length的值 修改指向
        if (len < 0) {
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        //1、len一定是一个正数  2、pl指向的链表是长的，ps指向短的
        while (len != 0) {
            pl = pl.next;
            len--;
        }
        while (pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        //pl == =ps,但可能为空
       /* if (pl == null) {
            return null;
        }*/
        return pl;
}

    public static void creatCut(MysingleList.ListNode headA, MysingleList.ListNode headB) {
        headB.next.next = headA.next.next;
    }

    public static void main(String[] args) {
        MysingleList mysingleList = new MysingleList();
        mysingleList.addLast(1);
        mysingleList.addLast(2);
        mysingleList.addLast(3);
        mysingleList.addLast(4);
        mysingleList.display3(mysingleList.head);
        System.out.println();
        mysingleList.display4();
        }
    public static void main6(String[] args) {
        MysingleList mysingleList = new MysingleList();
        mysingleList.addLast(11);
        mysingleList.addLast(21);
        mysingleList.addLast(31);
        mysingleList.addLast(41);
        mysingleList.display();

        mysingleList.creatLoop();

        boolean flag = mysingleList.hasCycle();
        System.out.println(flag);

        MysingleList.ListNode ret = mysingleList.detectCycle();
        System.out.println(ret.val);
    }
    public static void main5(String[] args) {
        MysingleList mysingleList1 = new MysingleList();
        mysingleList1.addLast(11);
        mysingleList1.addLast(21);
        mysingleList1.addLast(31);
        mysingleList1.addLast(41);
        mysingleList1.display();

        MysingleList mysingleList2 = new MysingleList();
        mysingleList2.addLast(8);
        mysingleList2.addLast(15);
        mysingleList2.addLast(29);
        mysingleList2.addLast(44);
        mysingleList2.display();

        creatCut(mysingleList1.head,mysingleList2.head);

        MysingleList.ListNode ret = getIntersectionNode(mysingleList1.head,mysingleList2.head);
        System.out.println(ret.val);
    }
    public static void main4(String[] args) {
        MysingleList mysingleList1 = new MysingleList();
        mysingleList1.addLast(11);
        mysingleList1.addLast(21);
        mysingleList1.addLast(31);
        mysingleList1.addLast(41);
        mysingleList1.display();

        MysingleList mysingleList2 = new MysingleList();
        mysingleList2.addLast(8);
        mysingleList2.addLast(15);
        mysingleList2.addLast(29);
        mysingleList2.addLast(44);
        mysingleList2.display();

        MysingleList.ListNode ret = mysingleList1.mergeTwoLists(mysingleList1.head,mysingleList2.head);
        mysingleList1.display(mysingleList1.head);
    }
    public static void main3(String[] args) {
        MysingleList mysingleList = new MysingleList();
        mysingleList.addLast(1);
        mysingleList.addLast(2);
        mysingleList.addLast(3);
        mysingleList.addLast(4);
        mysingleList.display();
        System.out.println("===========");
        System.out.println(mysingleList.middleNode().val);
        System.out.println("===========");
        MysingleList.ListNode ret = mysingleList.findkthToTail(2);
        System.out.println(ret.val);
    }
    public static void main2(String[] args) {
        MysingleList mysingleList = new MysingleList();
        mysingleList.addLast(1);
        mysingleList.addLast(2);
        mysingleList.addLast(3);
        mysingleList.addLast(4);
        mysingleList.display();
        System.out.println("===========");
        MysingleList.ListNode ret = mysingleList.reverseList();
         mysingleList.display(ret.next);
    }
    public static void main1(String[] args) {
        MysingleList mysingleList = new MysingleList();
        mysingleList.creatLink();
        mysingleList.display();
        System.out.println("==============");
        mysingleList.display();
        System.out.println("==============");
        System.out.println(mysingleList.contains(25));
        System.out.println("==============");
        System.out.println(mysingleList.size());
        System.out.println("==============");
        mysingleList.addFirst(1);
        mysingleList.display();
        mysingleList.addLast(3);
        mysingleList.display();
        System.out.println("==============");
       /* mysingleList.addIndex(1,99);
        mysingleList.display();
        try {
            mysingleList.addIndex(1,99);
        }catch (ListIndexOutOfException e) {
            e.printStackTrace();
        }
        System.out.println("==============");*/
        mysingleList.remove(12);
        mysingleList.display();
        System.out.println("==============");
        mysingleList.clear();
        mysingleList.display();
    }
}
