package io.programminglife.leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

 */
public class ContainsDuplicate2 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k <= 0) {
            return false;
        }
        
        Map<Integer, Integer> lookupMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(lookupMap.get(nums[i]) != null && i - lookupMap.get(nums[i]) <= k) {
                return true;
            } else {
                lookupMap.put(nums[i], i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;

        System.out.println(containsNearbyDuplicate(nums, k));
    }
    
}