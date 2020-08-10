package io.programminglife.leetcode.Arrays;

/**
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 *
 * Example 1:
 *
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 */
public class ShuffleArray {

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            arr[i] = i % 2 == 0 ? nums[i/2] : nums[i/2 + n];
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4};

        int[] result = shuffle(nums, 3);

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }

}
