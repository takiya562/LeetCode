package Week.No179;

import java.util.HashMap;
import java.util.LinkedList;

public class LeetCode_5355 {
    private static double helper(HashMap<Integer, LinkedList<Integer>> tree, int t, int target, int cur) {
        if (t == 0) {
            if (cur == target)
                return 1.0;
            else
                return 0;
        }
        else if (tree.containsKey(cur)){
            double res = 0;
            LinkedList<Integer> children = tree.get(cur);
            for (int child : children)
                res += helper(tree, t - 1, target, child);
            return (1.0 / children.size()) * res;
        }
        else
            return 0;
    }
    public static double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 0 || n < target)   return 0;
        HashMap<Integer, LinkedList<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            LinkedList<Integer> children;
            if (!tree.containsKey(edge[0])) {
                children = new LinkedList<>();
                children.add(edge[1]);
                tree.put(edge[0], children);
            }else {
                children = tree.get(edge[0]);
                children.add(edge[1]);
            }
        }
        return helper(tree, t, target, 1);
    }
    public static void main(String args[]) {
        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        frogPosition(7, edges, 2, 4);
    }
}
