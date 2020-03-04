package Week.No178;

import include.ListNode;
import include.TreeNode;

public class LeetCode_5346 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        return recursion(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    public boolean recursion(ListNode cur, TreeNode node) {
        if (cur == null)
            return true;
        if (node == null)
            return false;
        if (cur.val != node.val)
            return false;
        return recursion(cur.next, node.left) || recursion(cur.next, node.right);
    }
}
