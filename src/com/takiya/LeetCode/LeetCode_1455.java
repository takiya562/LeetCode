package com.takiya.LeetCode;

public class LeetCode_1455 {
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] splits = sentence.split("\\s+");
        for (int i = 0; i < splits.length; ++i) {
            if (splits[i].startsWith(searchWord))
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String sentence = "i love eating burger";
        System.out.println(isPrefixOfWord(sentence, "burg"));
    }
}
