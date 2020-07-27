package com.takiya.笔试;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeciAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        System.out.println(content);
        //匹配双引号的正则表达式
        String pattStr = "(?<=\")(\\-)*\\d+(?=\")";
        //创建Pattern并进行匹配
        Pattern pattern= Pattern.compile(pattStr);
        Matcher matcher=pattern.matcher(content);
        //将所有匹配的结果打印输出
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
