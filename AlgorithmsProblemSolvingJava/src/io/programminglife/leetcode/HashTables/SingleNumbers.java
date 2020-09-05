package io.programminglife.leetcode.HashTables;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumbers {

    public static int singleNumber(int[] nums) {
        Map<Integer, Boolean> dict = new HashMap<>();

        for(Integer num : nums) {
            dict.put(num, dict.get(num) == null);
        }

        for(Integer num : dict.keySet()) {
            if(dict.get(num)) {
                return num;
            }
        }

        return -1;
    }

    public static int singleNumberXOR(int[] nums) {
        int x = 0;

        for(int num : nums) {
            x = x ^ num;
        }

        return x;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,8,1,8};

        System.out.println(singleNumber(nums));

        System.out.println(singleNumberXOR(nums));
    }
    
}