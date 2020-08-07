package io.programminglife.leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8

 */
public class MissingNumer {

    public static int missingNumber(int[] nums) {
        Map<Integer, Integer> helper = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            helper.put(nums[i], i);
        }

        for(int i = 1; i <= nums.length; i++) {
            if(helper.get(i) == null) {
                return i;
            }
        }

        return 0;
    }

    /**
     * ∑ i=0 -> n i= n(n+1) / 2
     * @param nums
     * @return
     */
    public static int missingNumberGauss(int[] nums) {
        int gaussSum = (nums.length * (nums.length + 1)) / 2;
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return gaussSum - sum;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};

        System.out.println(missingNumberGauss(nums));
    }
    
}