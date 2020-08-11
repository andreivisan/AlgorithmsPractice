package io.programminglife.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * Return the answer in an array.
 *
 * Example 1:
 *
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 */
public class SmallerNumbersThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        //create a copy of the nums array and sort it
        // the position in the sorted array is equivalent with
        // the number of elements the current element is greater than
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        //put every element in the sorted array and its position
        //in the map
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < sortedNums.length; i++) {
            if(countMap.get(sortedNums[i]) == null) {
                countMap.put(sortedNums[i], i);
            }
        }

        //add the count to the result in the order of presence in
        //nums not in sorted nums
        for(int i = 0; i < nums.length; i++) {
            result[i] = countMap.get(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};

        int[] result = smallerNumbersThanCurrent(nums);

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
