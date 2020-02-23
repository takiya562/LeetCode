package Week.No177;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_5170 {
    Set<Integer> set;
    public boolean helper(int node, int[] leftChild, int[] rightChild) {
        if (node == -1) return true;
        if (set.contains(node)) return false;
        set.add(node);
        return helper(leftChild[node], leftChild, rightChild) && helper(rightChild[node], leftChild, rightChild);
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        set = new HashSet<>(n);
        return helper(0, leftChild, rightChild) && set.size() == n;
    }
}
