package com.takiya;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0) return ans;
        int cols = matrix[0].length;
        int len = rows * cols;
        int size = 0;
        int[] dirs = {0,1,0,-1,0};
        int dir = 0;
        int row = 0, col = 0;
        int round = 0;
        while(size != len) {
            ans.add(matrix[row][col]);
            size++;
            switch (dir) {
                case 0:
                    if (col == cols - 1 - round)
                        dir = (dir + 1) % 4;
                    break;
                case 1:
                    if (row == rows - 1 - round)
                        dir = (dir + 1) % 4;
                    break;
                case 2:
                    if (col == round)
                        dir = (dir + 1) % 4;
                    break;
                case 3:
                    if (row == round + 1) {
                        dir = (dir + 1) % 4;
                        ++round;
                    }
                    break;
            }
            row += dirs[dir];
            col += dirs[dir+1];
        }
        return ans;
    }
    public static void main(String args[]) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralOrder(matrix);
    }
}
