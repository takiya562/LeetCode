package com.takiya.笔试;

import java.util.Scanner;

public class hex2dec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(hex2Dec(scanner.nextLine()));
        }
    }
    public static int hex2Dec(String hex) {
        hex = hex.substring(2);
        int len = hex.length() - 1;
        int ans = 0;
        for (char c : hex.toCharArray()) {
            c = Character.toLowerCase(c);
            int num;
            if (c >= 97 && c <= 102)
                num = c - 87;
            else
                num = c - 48;
            ans += Math.pow(16, len--) * num;
        }
        return ans;
    }
}
