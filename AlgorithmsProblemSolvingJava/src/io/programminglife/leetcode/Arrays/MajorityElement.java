package io.programminglife.leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int majority = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(countMap.get(nums[i]) != null) {
                int tempCount = countMap.get(nums[i]) + 1;
                countMap.put(nums[i], tempCount);
            } else {
                countMap.put(nums[i], 1);
            }
        }
        
        int tempMajority = 0;
        for(int key : countMap.keySet()) {
            if(countMap.get(key) > tempMajority) {
                tempMajority = countMap.get(key);
                majority = key;
            }
        }

        return majority;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        System.out.println(majorityElement(nums));
    }
    
}