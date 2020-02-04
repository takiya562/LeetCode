package test;

import include.*;

import java.util.Stack;


public class Test {
    public static void main(String args[]) {
        char s = ' ';
        int a = s;
        System.out.println(a);
    }
    public static int getPara(String s, int index) {
        int temp = index;
        while (s.charAt(index) >= 48 && s.charAt(index) <= 57) ++index;
        return Integer.valueOf(s.substring(temp, index));
    }
}
