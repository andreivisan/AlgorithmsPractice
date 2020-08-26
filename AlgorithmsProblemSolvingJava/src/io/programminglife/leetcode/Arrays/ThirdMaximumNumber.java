package io.programminglife.leetcode.Arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }

        if(numsSet.size() < 3) {
            return Collections.max(numsSet);
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for(Integer number : numsSet) {
            if(number > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = number;
            } else if(number > secondMax) {
                thirdMax = secondMax;
                secondMax = number;
            } else if(number > thirdMax) {
                thirdMax = number;
            }
        }

        return thirdMax;
    }

    public static int kthMax(int[] nums, int k) {
        Set<Integer> maximums = new HashSet<>();

        for(int num : nums) {
            maximums.add(num);
            if(maximums.size() > k) {
                maximums.remove(Collections.min(maximums));
            }
        }

        if(maximums.size() == k) {
            return Collections.min(maximums);
        }

        return Collections.max(maximums);
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};

        System.out.print(kthMax(nums, 3));
    }

}
