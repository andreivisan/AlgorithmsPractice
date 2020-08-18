package io.programminglife.leetcode.HashTables;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        Map<Integer, Boolean> dict = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(dict.get(nums[i]) != null) {
                dict.put(nums[i], false);
            } else {
                dict.put(nums[i], true);
            }
        }

        for(Integer key : dict.keySet()) {
            if(dict.get(key)) {
                return key;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        System.out.println(singleNumber(nums));
    }

}
