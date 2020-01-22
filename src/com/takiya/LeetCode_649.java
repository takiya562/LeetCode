package com.takiya;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_649 {
    public String predictPartyVictory(String senate) {
        boolean R = true, D = true;
        int person = 0;
        char[] arr = senate.toCharArray();
        int len = arr.length;
        while (R && D) {
            R = false;
            D = false;
            for (int i = 0; i < len; i++) {
                if (arr[i] == 'R') {
                    R = true;
                    if (person < 0) arr[i] = '#';
                    ++person;
                }
                else if (arr[i] == 'D') {
                    D = true;
                    if (person > 0) arr[i] = '#';
                    --person;
                }
            }
        }
        return person > 0 ? "Radiant" : "Dire";
    }
}
