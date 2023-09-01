package BinaryTree;

import java.security.PublicKey;
import java.util.Scanner;

/**
 * ClassName: preToInOrder
 * Package: BinaryTree
 * Description:
 *  创建先序二叉树 再中序遍历
 * @Author 全家乐
 * @Create 2023/5/24 15:23
 * Version 1.0
 */
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
public class preToInOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            TreeNode root = createTree(str);
            inOrder(root );
        }
    }

    public static int i = 0;//递归的时候 每次都会定义为0
    public static TreeNode createTree(String str) {
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            root.left = createTree(str);
            root.left = createTree(str);
        }else {
            i++;
        }
        return root;
    }
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}
