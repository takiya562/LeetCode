package test;

import include.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;


public class Test {
    public static void main(String args[]) {
        String str = "2019-06-29";
        String[] split = str.split("-");
        for (int i = 0; i < split.length; ++i)
            System.out.println(Integer.valueOf(split[i]));
    }
}
