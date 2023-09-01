package LinkedList;

import LinkedStorage.ListIndexOutOfException;

import javax.swing.*;
import javax.xml.soap.Node;
import java.io.LineNumberReader;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: MyLinkedList
 * Package: LinkedStorage
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/14 1:19
 * Version 1.0
 */
public class MyLinkedList {
    static class ListNode {
        public int val;
        public ListNode prev;//前驱
        public ListNode next;//后继

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode last;

    //遍历
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //大小
    public int size() {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
    //查关键词key值
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //头插
    public ListNode addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null){
            head = node;
            last = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
    }
    //尾插
    public ListNode addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        return node;
    }
    //任意位置插入
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            throw new ListIndexOutOfException();
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }

        ListNode cur = findIndex(index);

        ListNode node = new ListNode(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }
    private ListNode findIndex(int index) {
        ListNode cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //删除
    public void removeAllKey(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == head) {
                    head = head.next;
                    if (head != null) { //排除只有一个结点
                        head.prev = null;
                    }
                }else {
                    //中间或尾巴
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        //中间
                        cur.next.prev = cur.prev;
                    }else {
                        //尾巴
                        last = cur.prev;
                    }
                }
                return;//去掉 return 删除所有的key
            }
         cur = cur.next;
        }
    }
    //清空
    public void clear() {
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;//head还有值
        last = null;
    }

}
