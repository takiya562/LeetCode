package com.takiya;

public class LeetCode_789 {

    /* 聪明的鬼会直接到终点等待 */
    /*
    证明：
         C
        /\
      D/  \
      / \  \
     /   \  \
     A       B

     鬼如果采取中间拦截的话，假设在D点拦截，此时AC = AD + DC = DB + DC >= BC
     所以鬼应该直接去终点。
    */

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int myDis, ghostDis = disCal(target, ghosts[0]);
        myDis = disCal(target, new int[2]);
        for (int[] ghost : ghosts) {
            int temp = disCal(target, ghost);
            ghostDis = ghostDis <= temp ? ghostDis : temp;
        }
        return myDis < ghostDis;
    }

    public int disCal(int[] target, int[] start) {
        return Math.abs(target[0] - start[0]) + Math.abs(target[1] - start[1]);
    }
}
