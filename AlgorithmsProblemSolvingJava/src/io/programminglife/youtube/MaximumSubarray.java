package io.programminglife.youtube;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int globalMax = Integer.MIN_VALUE, tempMax = 0;

        for (int i = 0; i < nums.length; i++) {
            tempMax = Math.max(nums[i], tempMax + nums[i]);
            globalMax = Math.max(globalMax, tempMax);
        }

        return globalMax;
    }
}
