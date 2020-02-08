package test;

import include.*;

import java.util.Arrays;
import java.util.Stack;


public class Test {
    public static void main(String args[]) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        Arrays.sort(costs, (o1, o2) -> {
            int gap1 = Math.abs(o1[1] - o1[0]);
            int gap2 = Math.abs(o2[1] - o2[0]);
            return gap2 - gap1;
        });
        System.out.print("sorted");
    }
}
