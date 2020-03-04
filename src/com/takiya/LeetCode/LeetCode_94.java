package com.takiya;

import include.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_94 {
    List<Integer> ans;
    public List<Integer> inorderTraversal_1(TreeNode root) {
        ans = new LinkedList<>();
        midOrder(root);
        return ans;
    }

    public void midOrder(TreeNode root) {
        if (root == null) return;
        midOrder(root.left);
        ans.add(root.val);
        midOrder(root.right);
    }

    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    /* 在本方法中left不再代表左子树，right不再代表右子树，它们实际代表前驱和后继 */
    public List<Integer> inorderTraversal_3(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            /* 针对cur最左的节点进行特化处理 */
            if (cur.left == null) {  //左子树为null，作为根节点可以进行输出了，并且接下来要搜索后继
                res.add(cur.val);
                cur = cur.right;
            }
            else {
                /* 针对每一个cur我们都需要去找它的前驱，在中序遍历中cur的前驱就在其左子树的最右边 */
                pre = cur.left;
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;

                /* 找到前驱需要分成两种情况：1、这是我们第一次找到这个前驱。2、这是我们第二次找到这个前驱 */
                if (pre.right == null) {   //第一次
                    pre.right = cur;    //第一次的时候我们需要告诉该节点它的前驱是谁
                    cur = cur.left;
                }

                if (pre.right == cur) { //第二次,我们需要复原，并输出当前节点,搜索后继
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
