package io.programminglife.leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of non-negative integers, return an array
 * consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortByParity {

    public static int[] sortArrayByParity(int[] A) {
        List<Integer> sorted = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                sorted.add(0, A[i]);
            } else {
                sorted.add(A[i]);
            }
        }

        for(int i = 0; i < sorted.size(); i++) {
            A[i] = sorted.get(i);
        }

        return A;
    }

    public static void main(String[] args) {
        int[] A = {3,1,2,4};
        int[] nums = sortArrayByParity(A);

        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

}
