package BinaryTree;/**
* ClassName: Test2
* Package: BinaryTree
* Description:  二叉搜索数和双向链表
* @Author 全家乐
* @Create 2023/6/2 20:40
* Version 1.0
*/public class Test2 {
    TreeNode prev = null;
    public void ConverChild(TreeNode pCur) {
        if (pCur == null) {
            return;
        }
        ConverChild(pCur.left);

        pCur.left = prev;
        if (prev != null) {
            pCur.right = pCur;
        }
        prev = pCur;

        //System.out.print(pCur.val+" ");
        ConverChild(pCur.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConverChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
}
