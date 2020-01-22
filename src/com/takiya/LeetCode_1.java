package com.takiya;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 {

    public static int[] twoSum(int[] nums, int target) {
       int[] result = new int[2];
       int complement;
       Map<Integer, Integer> map = new HashMap<>();
       for (int n=0; n<nums.length; n++)
       {
           map.put(nums[n], n);
       }
       for (int i=0; i<nums.length; i++)
       {
           complement = target - nums[i];
           if (map.containsKey(complement) && map.get(complement)!=i)
           {
               result[0] = i;
               result[1] = map.get(complement);
               break;
           }
       }
       return result;
    }

    public static void main(String[] args) {
	    int[] nums = {3,2,4};
	    int target = 6;
	    int[] result;
	    result = twoSum(nums, target);
	    System.out.println("[" + Integer.toString(result[0]) + "," +
                             Integer.toString(result[1]) + "]");
    }
}
