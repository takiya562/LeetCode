package com.takiya.笔试;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class unpackString {
    static Pattern pattern = Pattern.compile("\\[(\\d+)\\|(\\w+)\\]");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
            System.out.println(unpack(scanner.nextLine()));
    }

    public static String unpack(String s) {
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            int repeat = Integer.parseInt(m.group(1));
            String chs = "";
            for (int i = 0; i < repeat; ++i)
                chs += m.group(2);
            s = m.replaceFirst(chs);
            m = pattern.matcher(s);
        }
        return s;
    }
}
