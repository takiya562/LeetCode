package com.takiya;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_22 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        recursiveGenerate(0, 0, result, "", n);
        return result;
    }
    public static void recursiveGenerate(int left, int right, List<String> result, String str, int n) {
        if (right == n) {
            result.add(str.toString());
            return;
        }
        if (left > right)
            recursiveGenerate(left, right+1, result, str+')', n);
        if (left < n)
            recursiveGenerate(left+1, right, result, str+'(', n);
    }
    public static void main(String args[]) {
        List<String> result = generateParenthesis(3);
        System.out.print(result.toString());
    }
}
