package BinaryTree;

import Poker.Poker;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.xml.soap.Node;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * ClassName: TestBinaryTree
 * Package: BinaryTree
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/21 0:02
 * Version 1.0
 */
public class TestBinaryTree {

    static class TreeNode {
        public char val;//数据域
        public TreeNode left;//左孩子
        public TreeNode right;
        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode root;//二叉树的根节点

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
       // E.right = H;
        this.root = A;
        return root;
    }

    //前序遍历    根 -》 左子树 -》 右子树      递归
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.add(root.val);
        List<Integer> leftTree = preorderTraversal(root.left);
        ret.addAll(leftTree);
        List<Integer> rightTree = preorderTraversal(root.left);
        ret.addAll(rightTree);
        return ret;
    }*/
   /* List<Integer> ret = new ArrayList<>();//放在外边，不然每次再创建一个list
    public List<Integer> preorderTraversal(TreeNode root) {
       if (root == null) {
           return ret;
       }
       //System.out.print(root.val+" ");
       ret.add(root.val);
       preorderTraversal(root.left);
       preorderTraversal(root.left);
       return ret;
    }*/
 /*  public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> ret = new ArrayList<>();
       func(root,ret);
       return ret;
   }
   public void func(TreeNode root,List<Integer> ret) {
       if (root == null) {
           return;
       }
       ret.add(root.val);
       preorderTraversal(root.left);
       preorderTraversal(root.left);
   }*/

    //中序遍历     左子树-》根-》右子树
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    //后序遍历       左右中
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    //获取一共多少个结点 子问题：左树的结点 + 右树的结点 + 1
    //时间复杂度：O（N）     空间复杂度：O（lgN）
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return leftSize+rightSize+1;
    }
    //遍历思路
    public int nodeSize;//不能加static 不然第二遍引用就出问题了

    public void size2(TreeNode root) {
        if (root == null) {
            return;
        }
        nodeSize++;
        size2(root.left);
        size2(root.right);
    }
    //获取叶子结点的个数
    //左叶子+右叶子
    //遍历 root为0 ++
    public int getleafNodecount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftLeave = getleafNodecount(root.left);
        int rightleave = getleafNodecount(root.right);
        return leftLeave+rightleave;
    }

    public int leaveSize;

    public int getleafNodecount2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            leaveSize++;
        }
        getleafNodecount2(root.left);
        getleafNodecount2(root.right);
        return leaveSize;
    }
    //求第k层节点的个数
    //子问题：k-1 层的 left+right
    public int getKLeaveNodeCount(TreeNode root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int leftSize = getKLeaveNodeCount(root.left,k-1);
        int rightSize = getKLeaveNodeCount(root.right,k-1);
        return leftSize+rightSize;
    }
    //求二叉树高度
    //左右高度的最大值 + 1
    //时间复杂度：O（N）   空间复杂度O（树的高度）
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return(leftHeight > rightHeight? (leftHeight+1) : (rightHeight+1));
    }
    //检测值为value的值在树中是否存在、
    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        }
        TreeNode leftTree = find(root.left,val);
        if (leftTree != null) {
            return leftTree;
        }

        TreeNode rightTree = find(root.right,val);
        if(rightTree != null){
            return rightTree;
        }
        else{
            return null;
        }
    }
    //判断两棵树是否相同  结构 和 值都一样
    /*1个为空，一个不为空   不是
      两个都是空          是
      两个都不是空         不一定
     */
    //时间复杂度：O(min(m,n))       空间复杂度:O(min(m,n))   m,n 分别为两颗树的节点数
    public boolean isSameTree(TreeNode p, TreeNode q) {
         if (p != null && q == null || p== null && q != null) {
             return false;
         }
         //要么都是空要么都不是空
        if (p == null && q == null) {
            return true;
        }
         if (p.val != q.val) {
             return false;
         }
         //p q都不空 且值一样
         return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    //另一颗树的子树
    //时间复杂度o（s*t）
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {//空指针异常
            return false;
        }
        if (isSameTree(root,subRoot)) {
            return true;
        }
        if (isSubtree(root.left,subRoot)) {
            return true;
        }
        if (isSubtree(root.right,subRoot)) {
            return true;
        }
        return false;
    }
    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    //二叉树高度不超过1
    //时间复杂度O（N^2）  每个节点求高度，哪个节点
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight - rightHeight) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    //复杂度O（N）  求高度过程中就判断是否平衡
    public boolean isBalanced2(TreeNode root) {
        return maxDepth(root) >= 0;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        if (leftHeight >=0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight,rightHeight)+1;
        }else {
            return -1;
        }
    }
    //判断是否为轴对称
    //判断左子树和右子树是否对称
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);

    }
    public boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree != null && rightTree == null || leftTree == null && rightTree != null) {
            return false;
        }
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }
        return isSymmetricChild(leftTree.left, rightTree.right) && isSymmetricChild(leftTree.right, rightTree.left);
    }
    //二叉树的层序遍历
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val+" ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
/*
    //知道每层 节点个数
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while ( size != 0) {
                TreeNode cur = queue.poll();
                //System.out.print(cur.val+" ");
                temp.add(cur.val);
                size--;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            list.add(temp);
        }
        return list;
    }
*/


    public static int i = 0;//递归的时候 每次都会定义为0
    public static TreeNode createTree(String str) {
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;//不用担心i越界，回退次数的是一定的
            root.left = createTree(str);
            root.left = createTree(str);
        }else {
            i++;
        }
        return root;
    }
    //最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //先判断根节点是不是q||p
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftRet = lowestCommonAncestor(root.left,p,q);
        TreeNode rightRet = lowestCommonAncestor(root.right,p,q);
        if (leftRet != null && rightRet != null) {  //一个在左，一个在右
            return root;
        }else if(leftRet != null) { //都在左  左边找到了一个就直接返回了
            return leftRet;
        }else if (rightRet != null) {
            return rightRet;
        }
        return null;
    }
    //如果每个节点都放有父亲节点的地址（求相交点）
    //找到从根节点到指定节点node路径上的所有节点，存放到栈当中
    public boolean getPath(TreeNode root,TreeNode node,Deque<TreeNode> stack) {
        if(root == null || node == null) {
            return false;
        }
        stack.push(root);
        //放完之后要检查
        if (root == node) {
            return true;
        }

        boolean ret1 = getPath(root.left,node,stack);
        if (ret1 == true) {
            return true;
        }
        boolean ret2 = getPath(root.right,node,stack);
        if (ret2 == true) {
            return true;
        }
        stack.pop();
        return false;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //1、两个栈当中  存储好数据
        Deque<TreeNode> stack1 = new LinkedList<>();
        getPath(root,p,stack1);
        Deque<TreeNode> stack2 = new LinkedList<>();
        getPath(root,q,stack2);
        //2、判断栈的大小
        int size1 = stack1.size();
        int size2 = stack2.size();
        if (size1 > size2) {
            int size = size1 - size2;
            while (size != 0) {
                stack1.pop();
                size--;
            }
        }else {
            int size = size2 - size1;
            while (size != 0) {
                stack2.pop();
                size--;
            }
        }
        //栈里数据个数一样
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() != stack2.peek()) {
                stack1.pop();
                stack2.pop();
            }else {
                return stack1.peek();
            }
        }
        return null;
    }
    /*//根据一棵树的前序遍历和中序遍历  构建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildTreeChild(int[] preorder,int[] inorder,int inbegin,int inend) {
        if (inbegin > inend) {
            return null;//，没有子树了
        }

        TreeNode node = new TreeNode(preorder[i]);

        //找到现在root 在中序遍历的位置
        int rootIndex = findindex(inorder,inbegin,inend,preorder[i]);
        i++;

        root.left = buildTreeChild(preorder,inorder,inbegin,rootIndex-1);
        root.right = buildTreeChild(preorder,inorder,rootIndex+1,inend);

        return root;
    }
    private int findindex(int[] inorder, int inbegin, int inend, int key) {//找到现在root 在中序遍历的位置
        for (int i = inbegin; i <= inend; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }*/

    /*//根据后序和中序
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        i = postorder.length-1;
        return buildTreeChild(postorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildTreeChild(int[] postorder,int[] inorder,int inbegin,int inend) {
        if (inbegin > inend) {
            return null;//，没有子树了
        }

        TreeNode node = new TreeNode(postorder[i]);

        //找到现在root 在中序遍历的位置
        int rootIndex = findindex(inorder,inbegin,inend,postorder[i]);
        i--;

        root.right = buildTreeChild(postorder,inorder,rootIndex+1,inend);
        root.left = buildTreeChild(postorder,inorder,inbegin,rootIndex-1);

        return root;
    }
    private int findindex(int[] postorder, int inbegin, int inend, int key) {//找到现在root 在中序遍历的位置
        for (int i = inbegin; i <= inend; i++) {
            if (postorder[i] == key) {
                return i;
            }
        }
        return -1;
    }*/

    //给根节点root 采用前序遍历的方式 将二叉树转化为一个由括号和整数组成的字符串  返回构造出的字符串
    public String tree2str(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        tree2strChilde(root,stringBuilder);

        return stringBuilder.toString();
    }
    public void tree2strChilde(TreeNode t, StringBuilder stringBuilder) {
        if (t == null) {
            return;
        }

        stringBuilder.append(t.val);
        if (t.left != null) {
            stringBuilder.append("(");
            tree2strChilde(t.left,stringBuilder);
            stringBuilder.append(")");
        }else {
            if (t.right != null) {//左边为空 右边不为空
                stringBuilder.append("()");
            }else {//左右都空
                return;
            }
        }

        if (t.right == null) {
            return;
        }else {
            stringBuilder.append("(");
            tree2strChilde(t.right,stringBuilder);
            stringBuilder.append(")");
        }
    }

    //把二叉搜素树转成有序双向链表
    TreeNode prev = null;
    public void inorder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorder(cur.left);

        cur.left = prev;//第一次执行 把最左边的左边置为null; 不是第一次 prev是当前cur的前序
        if (prev != null) {
            prev.right = cur;
        }
        prev = cur;
        inorder(cur.right);
    }
    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorder(root);//中序遍历完已变成双向链表

        TreeNode head = root;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
    //判断是否为完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        //cur == null
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                return false;
            }
        }
        return true;
    }
    //栈 前序遍历
    public void preOrderNor(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val +" ");
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }
    //中序
    public void inOrderNor(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = cur.right;
        }
    }
    //后序
    public void postOrderNor(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev ) {
                System.out.println(top.val+" ");
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }
            cur = top.right;
        }
    }




}
