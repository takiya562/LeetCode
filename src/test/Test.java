package test;

import include.*;

import java.util.*;


public class Test {
    public static void main(String args[]) {
        String str = "😋ABC";
        int[] codePoints = str.codePoints().toArray();
        System.out.println(str.substring(1,2));
        for (int i = 0 ; i < codePoints.length; ++i)
            System.out.print(codePoints[i] + " ");
    }
}
