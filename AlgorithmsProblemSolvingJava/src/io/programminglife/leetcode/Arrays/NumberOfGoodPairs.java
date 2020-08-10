package io.programminglife.leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums.
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * Return the number of good pairs.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 *
 * Response: if number of i = N => number of pairs of i = N * (N-1)/2
 */
public class NumberOfGoodPairs {

    public static int numIdenticalPairs(int[] nums) {
        // Count frequncies
        HashMap<Integer, Integer> counts = new HashMap<>();

        // Maximum 100 iterations
        for (int i = nums.length - 1; i >= 0; i--) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        int ret = 0;

        // Maximum 100 iterations
        for (int key : counts.values()) {
            ret += key * (key - 1)/2;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};

        System.out.println(numIdenticalPairs(nums));
    }

}
