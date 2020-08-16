package io.programminglife.leetcode.Arrays;

/**
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 *
 * Example 1:
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 *
 * Example 2:
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 */
public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {
        int flag = 0;

        if(nums.length < 2) {
            return true;
        }

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                flag++;
            }
            if(flag > 1) {
                return false;
            }
            if(i > 0 && i < nums.length - 2) {
                if(nums[i + 1] < nums[i - 1] && nums[i] > nums[i + 2]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,3};

        System.out.println(checkPossibility(nums));
    }

}
