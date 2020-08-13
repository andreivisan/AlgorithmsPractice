package io.programminglife.leetcode.Arrays;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 * Example 1:
 *
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class FlipAndInvertImage {

    public static int[][] flipAndInvertImage(int[][] A) {
        int[][] flipped = new int[A.length][];

        for(int i = 0; i < A.length; i++) {
            int[] reversedRow = reverseArray(A[i]);
            for(int j = 0; j < reversedRow.length; j++) {
                reversedRow[j] = reversedRow[j] ^ 1;
            }
            flipped[i] = reversedRow;
        }

        return flipped;
    }

    public static int[] reverseArray(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n/2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i -1];
            nums[n - i - 1] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,0}, {1,0,1},{0,0,0}};
        int[][] flippedImage = flipAndInvertImage(image);

        System.out.print("[");
        for(int i = 0; i < flippedImage.length; i++) {
            System.out.print("[");
            int[] row = flippedImage[i];
            for(int j = 0; j < row.length; j++) {
                if(j < row.length - 1) {
                    System.out.print(row[j] + ",");
                } else {
                    System.out.print(row[j]);
                }
            }
            System.out.print("], ");
        }
        System.out.print("], ");
    }
}
