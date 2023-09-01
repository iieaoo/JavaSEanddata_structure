package BinaryTree;

import java.awt.image.Kernel;
import java.util.*;

/**
 * ClassName: Test
 * Package: BinaryTree
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/20 23:44
 * Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        TestBinaryTree binaryTree = new TestBinaryTree();
        TestBinaryTree.TreeNode root = binaryTree.createTree();
        System.out.println(binaryTree.isCompleteTree(root));
        binaryTree.preOrderNor(root);
    }
    public static void main3(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        TestBinaryTree.TreeNode root = testBinaryTree.createTree("ABC##DE#G##F###");
     /*   TestBinaryTree.TreeNode ret = testBinaryTree.invertTree(root);
        System.out.println(ret.val);
        System.out.println("=========")*/;
        System.out.println("层序遍历：");
        testBinaryTree.levelOrder(root);
    }
    public static void main2(String[] args) {
        TestBinaryTree binaryTree = new TestBinaryTree();
        TestBinaryTree.TreeNode root = binaryTree.createTree();
        System.out.println("============");
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();
        System.out.println("============");
        System.out.println("节点个数："+binaryTree.size(root));
        binaryTree.size2(root);
        System.out.println("节点个数2："+binaryTree.nodeSize);
        System.out.println("叶子节点的个数:"+binaryTree.getleafNodecount(root));
        System.out.println("第k层节点个数："+binaryTree.getKLeaveNodeCount(root,3));
        TestBinaryTree.TreeNode ret = binaryTree.find(root,'E');
        System.out.println("找值为val的节点："+ret.val);
    }
    public static void main1(String[] args) {
        //可读性比下边好
        Queue<Integer> stack = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        Deque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(2);
        Deque<Integer> stack3 = new LinkedList<>();
        stack3.push(1);

        //不常用 不明了
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
    }
}
