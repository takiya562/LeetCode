package com.takiya.Offer;

import java.util.Arrays;

public class Offer_45 {
    private int compare(String num1, String num2) {
        int index = 0;
        while (index < num1.length() && index < num2.length()) {
            if (num1.charAt(index) < num2.charAt(index))
                return -1;
            else if (num1.charAt(index) > num2.charAt(index))
                return 1;
            else
                index++;
        }
        if (index < num2.length())
            return compare(num1, num2.substring(index));
        else if (index < num1.length())
            return compare(num1.substring(index), num2);
        else
            return 0;
    }
    public String minNumber(int[] nums) {
        String[] arrays = new String[nums.length];
        for (int i = 0; i < nums.length; ++i)
            arrays[i] = String.valueOf(nums[i]);
        Arrays.sort(arrays, (i, j) -> {
            return compare(i, j);
        });
        StringBuilder sb = new StringBuilder();
        for (String str : arrays)
            sb.append(str);
        return sb.toString();
    }
}
