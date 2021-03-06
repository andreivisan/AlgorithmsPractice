package io.programminglife.leetcode.Arrays;

/**
 * Given an integer n and an integer start.
 * Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.
 * Return the bitwise XOR of all elements of nums.
 *
 * Example 1:
 *
 * Input: n = 5, start = 0
 * Output: 8
 * Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
 * Where "^" corresponds to bitwise XOR operator.
 */
public class XOROperationOnArray {

    public static int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int xor = nums[0];
        for(int i = 0; i < n; i++) {
            nums[i] = start + 2*i;
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
    }

}
