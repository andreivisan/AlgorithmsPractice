package io.programminglife.leetcode.HashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i - 1] != nums[i]) {
               twoSum(nums, i, result);
           }
        }

        return result;
    }

    static void twoSum(int[] nums, int i, List<List<Integer>> result) {
        var seen = new HashSet<Integer>();

        for(int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            if(seen.contains(complement)) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(nums[j]);
                triplet.add(complement);
                result.add(triplet);

                while(j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j = j + 1;
                }
            }

            seen.add(nums[j]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = threeSum(nums);
    }
    
}
