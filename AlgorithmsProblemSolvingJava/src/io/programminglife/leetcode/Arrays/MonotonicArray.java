package io.programminglife.leetcode.Arrays;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].
 * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 *
 * Example 1:
 *
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 *
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 *
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 *
 * Input: [1,1,1]
 * Output: true
 */
public class MonotonicArray {

    public static boolean isMonotonic(int[] A) {
        return isMonotonicAscending(A) || isMonotonicDescending(A);
    }

    private static boolean isMonotonicAscending(int[] A) {
        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] > A[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isMonotonicDescending(int[] A) {
        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] < A[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] A = {1,3,2};

        System.out.println(isMonotonic(A));
    }

}
