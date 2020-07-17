package com.takiya.LeetCode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LeetCode_1263 {
    int mask = 0x1f;
    int step_unmask = 0xfffff;
    int step_mask = 0xfff << 20;
    int player_row_mask = mask << 15;
    int player_col_mask = mask << 10;
    int box_row_mask = mask << 5;
    int box_col_mask = mask;
    int[] dirs = {0, 1, 0, -1, 0};
    public int minPushBox(char[][] grid) {
        int ans = Integer.MAX_VALUE;
        int rows = grid.length;
        if (rows == 0)  return -1;
        int cols = grid[0].length;
        int player_row = 0, player_col = 0, box_row = 0, box_col = 0;
        int target_row = 0, target_col = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 'S') {
                    player_row = i;
                    player_col = j;
                } else if (grid[i][j] == 'B') {
                    box_row = i;
                    box_col = j;
                } else if (grid[i][j] == 'T') {
                    target_row = i;
                    target_col = j;
                }
            }
        }
        Map<Integer, Integer> visited = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(encode(player_row, player_col, box_row, box_col, 0));
        while (!q.isEmpty()) {
            int code = q.remove();
            int step = (code & step_mask) >>> 20;
            player_row = (code & player_row_mask) >>> 15;
            player_col = (code & player_col_mask) >>> 10;
            box_row = (code & box_row_mask) >>> 5;
            box_col = code & box_col_mask;
            visited.put(code & step_unmask, step);
            if (step >= ans) continue;
            for (int i = 0; i < 4; ++i) {
                int pr = player_row + dirs[i], pc = player_col + dirs[i + 1];
                int br = box_row + dirs[i], bc = box_col + dirs[i + 1];
                if (pr == box_row && pc == box_col) {
                    if (br < rows && bc < cols && br >= 0 && bc >= 0 && grid[br][bc] != '#')
                    {
                        if (br == target_row && bc == target_col) {
                            ans = Math.min(ans, step + 1);
                            continue;
                        }
                        code = encode(pr, pc, br, bc, step + 1);
                        if (visited.getOrDefault(code & step_unmask, Integer.MAX_VALUE) > step + 1) {
                            q.add(code);
                        }
                    }
                }
                else if (pr < rows && pc < cols && pr >= 0 && pc >= 0 && grid[pr][pc] != '#')
                {
                    code = encode(pr, pc, box_row, box_col, step);
                    if (visited.getOrDefault(code & step_unmask, Integer.MAX_VALUE) > step) {
                        q.add(code);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int encode(int player_row, int player_col, int box_row, int box_col, int step) {
        int encode = player_row << 15;
        encode |= player_col << 10;
        encode |= box_row << 5;
        encode |= box_col;
        encode |= step << 20;
        return encode;
    }

    @Test
    public void test() {
        char[][] grid = {
                {'.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','#'},
                {'.','.','.','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','#'},
                {'#','#','.','.','#','.','.','.','.','.','.','.'},
                {'#','.','#','#','#','.','B','.','.','.','.','.'},
                {'.','.','#','.','.','.','#','#','#','.','.','.'},
                {'.','#','.','.','.','.','.','.','.','#','.','.'},
                {'.','.','.','S','#','#','T','.','.','.','#','.'},
                {'.','.','.','.','.','.','.','.','#','.','#','.'},
                {'.','.','.','.','.','.','.','.','.','.','.','.'},
                {'#','.','.','.','.','.','.','.','.','.','#','.'}
        };
        LeetCode_1263 l = new LeetCode_1263();
        long start = System.currentTimeMillis();
        int i = l.minPushBox(grid);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
