package LinkedStorage;

import org.w3c.dom.NodeList;

import javax.swing.undo.CannotUndoException;
import java.util.LinkedList;
import java.util.Stack;

/**
 * ClassName: MysingleList
 * Package: LinkedStorage
 * Description: shift+F6 换整个代码的这个值(fn+esc)
 *链式存储：链表   学习： 单项 不带头 非循环       双向 带头 非循环
 *   单向  双向
 *   带头  不带头
 *   循环  不循环
 *  插入不用挪动元素 只是修改指向
 * @Author 全家乐
 * @Create 2023/5/11 19:39
 * Version 1.0
 */
public class MysingleList {
    //脱离列表没有意义 定为内部类
    static class ListNode {
        public int val;//存储的数据
        public ListNode next;//下一个数据

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;   //代表当前链表的头节点的引用

    public void creatLink() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(25);
        ListNode node3 = new ListNode(76);
        ListNode node4 = new ListNode(23);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = node1;
    }

    //遍历链表
    public void display() {
        //如果说 要把整个链表遍历完成 那么 就需要head == null
        //如果说 要遍历到链表的尾巴 那么 head.next == null
        ListNode cur = head;    //代跑  不然head就没有了 不能再次打印
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //从指定位置打印
    public void display(ListNode newHead) {
        //如果说 要把整个链表遍历完成 那么 就需要head == null
        //如果说 要遍历到链表的尾巴 那么 head.next == null
        ListNode cur = newHead;    //代跑  不然head就没有了 不能再次打印
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //递归逆置打印链表
    public void display3(ListNode pHead) {
        if (pHead == null) {
            return;
        }
        if (pHead.next == null) {
             System.out.print(pHead.val+" ");
            return;
        }
        display3(pHead.next);
        System.out.print(pHead.val+ " ");
    }
    public void display4() {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //遍历栈
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            System.out.print (top.val + " ");
        }
        System.out.println();
    }
    //查找是否包含关键字Key
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
    //得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }
    //尾插法
        public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = head;
        if (head == null) { //如果链表为空
            head = node;
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入
    public void addIndex(int index,int data) throws ListIndexOutOfException{
        checkIndex(index);
        ListNode node = new ListNode(data);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
        }
        ListNode cur = findIndexSubOne(index);//走到index的上一个节点位置
        node.next = cur.next;
        cur.next = node;
    }
    private ListNode findIndexSubOne(int index) {
        ListNode cur = head;
        int count = 0;
        while (count != index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new ListIndexOutOfException("index位置不合法");
        }
    }
    //删除第一次出现的关键字key的结点
    public void remove(int key) {
        if (head == null) {
            return;//一个节点没有
        }
        if (head.val == key) {
            head = head.next;
            return;
        }
        ListNode cur = searchPrec(key);
        if (cur == null) {
            return;
        }
        ListNode del = cur.next;
        cur.next = del.next;
    }
    private ListNode searchPrec(int key) {
        //找到关键字key头一个节点
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {  //cur是key的前驱结点
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;//没有你要删除的结点
    }
    //删除所有值为key的结点
    public void removeAllKey(int key) {
        if (head == null) {
            return;
        }
       /* while (head.val == key) {
            head = head.next;
        }*/
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == key) {
            head = head.next;
            return;
        }
    }
    //清空
    public void clear() {
        head = null;
    }
    public ListNode reverseList() {    //反转链表
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            //头插法
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }
    //   给定一个头结点head的非空单链表 返回链表的中间结点
    //   如果有两个中间结点，则返回第二个结点
    //   1、快慢指针 快指针比慢指针速度快两倍  fast == null || fast.next == null
    public MysingleList.ListNode middleNode() {
        MysingleList.ListNode fast = head;
        MysingleList.ListNode slow = head;
        while (fast != null && fast.next != null) { //对于偶数个 第一个错，第二个表达式不执行 fast->null
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //找倒数第k个 先让fast走k-1步 fast走完之后 和slow开始一步一步走
    //当fast.next为空的时候，slow所指的位置就是倒数第k个
    public ListNode findkthToTail(int k) {
        if (k <= 0 || head == null) {
            return null;
          }
        ListNode fast = head;
        ListNode slow = head;
        //1、fast走k-1步
        while (k-1 != 0) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            k--;
        }
        //2、3
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //合并有序链表
    public ListNode mergeTwoLists(ListNode head1,ListNode head2) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        if (head1 != null) {
            temp.next = head1;
        }
        if (head2 != null) {
            temp.next = head2;
        }
        return newHead.next;
    }
    //链表的回文结构  先找中间结点 把后半部分反转
    public boolean chkPalindrome() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        //1、找中间结点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、反转
        ListNode cur = slow.next;//代表现在需要反转的结点
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3、一个从头往后 一个从后往前
        while (slow != head) {
            if (head.val != slow.val) {
                return false;
            }
            //偶数的情况
            if (head.next == slow) {
                return true;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    //现有一链表的头指针ListNode*pHead,给一定值x，将所有小于X的结点排在其余结点之前，不能改变原来数据顺序，返回重新排列后的链表的头指针
    public ListNode  partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //解决第一段为空，拿到第二段数据 第二段空，返回第一段
        //有可能不会同时存在小于x,或大于等于x的数据
        if (bs == null) {
            return as;
        }
        //第一个段不为空
        be.next = as;
        if (as != null) {
            ae.next = null;
        }
       // ae.next = null;//error 第二个段可能为空
        return bs;
    }
    //给定一个链表，判断是否有环（可以理解为数学追击问题）
    //快慢指针，一个走一步，一个走两步 最多差一个环的距离
    public boolean hasCycle() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
    public boolean hasCycle2() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        return true;
    }
    public void creatLoop() {   //创建环
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head.next.next;
    }
    //返回链表开始环的第一个结点，如果链表无环，返回null
    /*设环的周长C 头到入口点距离为X  相遇点和入口点Y
    fast走完了一圈走的路程：X+C+(C-Y)  slow走的路程：X+(C-Y)
    fast的速度是slow的2倍，路程也是2倍 2*（X+(C-Y)）= X+C+(C-Y)
    展开：X == Y
    fast走完了N圈  X == (N-1)C+Y*/
    public ListNode detectCycle() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        //X == Y
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        head.next = pHead;//加一个空结点，因为头节点有可能被删除
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.next != null && cur.next.val == cur.val){
                // 相同结点一直前进
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                //一开始就重复
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }
    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    //给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        //头节点值为val
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }
    //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
    //两数相加
    //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;  //进位
        while (l1 != null || l2 != null) {
            int cur1 = l1 == null ? 0 : l1.val;
            int cur2 = l2 == null ? 0 : l2.val;
            int sum = cur1 + cur2 + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int flag = 0;//字串起始位置
        int length = 0;
        int res = 0;//记录最长字符串长度
        while (i < s.length()) {
            int index = s.indexOf(s.charAt(i),flag);//可返回某个指定的字符串值在字符串中首次出现的位置。
            if (index < i) { //从flag开始 出现了重复字符
                if (length > res) {
                    res = length;
                }
                if (res >= s.length() - index -1) {//字符串后边省的不够再重复一次
                    return res;
                }
                length = i - index - 1;
                flag = index + 1;
            }
            length++;
            i++;
        }
        return length;
    }

}
