package io.programminglife.leetcode.BinarySearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
public class Search2DMatrix {

    public boolean searchMatrixLog(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
    
        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
          pivotIdx = (left + right) / 2;
          pivotElement = matrix[pivotIdx / n][pivotIdx % n];
          if (target == pivotElement) return true;
          else {
            if (target < pivotElement) right = pivotIdx - 1;
            else left = pivotIdx + 1;
          }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        if (matrix.length == 1) {
            return binarySearch(matrix[0], target);
        }

        int[] nums = findArray(matrix, target);

        if (nums != null) {
            return binarySearch(nums, target);
        }

        return false;
    }

    private static int[] findArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length - 1] >= target) {
                return matrix[i];
            }
        }

        return null;
    }

    private static boolean binarySearch(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + ((right - left) / 2);

            if(x == nums[mid]) {
                return true;
            } else if(x < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,   3,  5,  7}, 
            {10, 11, 16, 20}, 
            {23, 30, 34, 50}};

        System.out.println(searchMatrix(matrix, 13));
    }
    
}
