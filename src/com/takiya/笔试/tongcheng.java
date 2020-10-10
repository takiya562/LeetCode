package com.takiya.笔试;

import include.TreeNode;

import java.util.*;

public class tongcheng {
    static int m;
    static int n;
    static int[] dirs = {-1, 0, 1, 0, -1};
    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int[][] graph = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    count++;
                    dfs(graph, i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] graph, int i, int j) {
        graph[i][j] = -1;
        for (int k = 0; k < 4; k++) {
            int r = i + dirs[k];
            int c = j + dirs[k + 1];
            if (verify(r, c) && graph[r][c] == 1) {
                dfs(graph, r, c);
            }
        }
    }
    private static boolean verify(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    /**
     *
     * @param node TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
        // write code here
        if (node == null)
            return null;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- != 0) {
                TreeNode cur = q.remove();
                list.add(cur.val);
                if (cur.left != null)   q.add(cur.left);
                if (cur.right != null)  q.add(cur.right);
            }
            ans.add(list);
        }
        return ans;
    }

    public int firstMissingPositive (int[] nums) {
        // write code here
        int n = nums.length;
        if (n == 0)
            return 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 1;
        while (set.contains(ans))   ans++;
        return ans;
    }
    public static void main(String[] args) {
        solution1();
    }
}
