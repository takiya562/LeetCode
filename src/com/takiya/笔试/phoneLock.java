package com.takiya.笔试;

import org.junit.Test;

import java.util.Arrays;

public class phoneLock {
    static int[][] directs = {{-1,1},{0,1},{1,1},{-1,0},{1,0},{-1,-1},{0,-1},{1,-1},
            {2,-1},{1,-2},{-2,-1},{-1,-2},{1,2},{2,1},{-2,1},{-1,2}};

    static int[][] dash = { {1,2,3},
            {4,5,6},
            {7,8,9}};

    static int[] nums = new int[10];

    static public int solution(int m,int n){
        m = m<=9 ? m : 9;
        n = n<=9 ? n : 9;
        int sum=0;
        int[] nums ={0, 9, 56, 320, 1624, 7152, 26016, 72912, 140704, 140704 };
        for (int i=m;i<=n;i++){
            sum += nums[i];
        }
        return sum;
    }

    static public void process(boolean[] V,int count,int x,int y){
        if(count==9){
            nums[count]++;
            return;
        }
        V[dash[x][y]]=true;
        nums[count]++;

        for(int i=0;i<directs.length;i++){
            int a= x+directs[i][0];
            int b= y+directs[i][1];
            if(canVisit(V,a,b)){
                process(V,count+1,a,b);
            }else if(i<8){ // 若是常规方向，则再多走一步则可以走到与当前点不相邻的点
                a +=directs[i][0];
                b +=directs[i][1];
                if(canVisit(V,a,b)){
                    process(V,count+1,a,b);
                }
            }
        }
        V[dash[x][y]]=false;
    }

    static boolean canVisit(boolean[] V,int i,int j){
        if(i<0 || i>=3 || j<0 || j>=3 || V[dash[i][j]]) return false;
        return true;
    }

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                process(new boolean[10],1,i,j);
            }
        }

        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
