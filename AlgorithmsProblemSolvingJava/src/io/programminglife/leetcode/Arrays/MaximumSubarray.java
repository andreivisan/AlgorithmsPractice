package io.programminglife.leetcode.Arrays;

public class MaximumSubarray {
    public int maxSubArray1(int[] nums) {
        int currentMax = Integer.MIN_VALUE, sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            currentMax = Math.max(sum, currentMax);
            sum = Math.max(sum, 0);
        } 

        return currentMax;
    }

    public int maxSubArray2(int[] nums) {
        int globalMax = Integer.MIN_VALUE, tempMax = 0;
        
        for (int i = 0; i < nums.length; i++) {
            tempMax = Math.max(nums[i], nums[i] + tempMax);
            globalMax = Math.max(tempMax, globalMax);
        } 

        return globalMax;
    }
}
