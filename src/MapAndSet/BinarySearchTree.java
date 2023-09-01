package MapAndSet;

import java.time.temporal.ValueRange;
import java.util.HashMap;

/**
 * ClassName: BinarySearchTree
 * Package: MapAndSet
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/29 23:56
 * Version 1.0
 */
public class BinarySearchTree {
    static class TreeNode {
        public int val;
        public TreeNode right;
        public TreeNode left;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode root = null;
    //查找二叉搜索树中指定的val值
    public TreeNode find(int val){
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            } else if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            }
        }
         return null;
    }
    //插入一个数据
    //都插入到叶子节点
    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            }else if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {
                return;
            }
        }
        TreeNode node = new TreeNode(val);
        if (parent.val < val) {
            parent.right = node;
        }else {
            parent.left = node;
        }
    }
    //中序
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    //删除
    public void remove(int val) {
         TreeNode cur = root;   // 要删除的节点
         TreeNode parent = null;
         while (cur != null) {
             if (cur.val == val) {
                 removeNode(parent,cur);//alt+回车 生成方法
                 return;
             }else if(cur.val < val) {
                 parent = cur;
                 cur = cur.right;
             }else {
                 parent = cur;
                 cur = cur.left;
             }
         }
    }
    private void removeNode(TreeNode parent, TreeNode cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            }else if (parent.left == cur) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }else if (parent.right == cur) {
                parent.right = cur.left;
            }else {
                parent.left = cur.left;
            }
        }else  {
            TreeNode target = cur.right;
            TreeNode targetParent = cur;
            while (target.left != null) {//找最小值替换 删除
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (target == targetParent.left) {
                targetParent.left =target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }
    //字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


}
