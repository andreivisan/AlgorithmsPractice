package io.programminglife.leetcode.BinarySearch;

/**
 * You are given an integer array nums sorted in ascending order, and an integer target.
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * If target is found in the array return its index, otherwise, return -1.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int pivot = find_rotate_index(nums, 0, nums.length - 1);

        if (pivot == 0) {
            return binarySearchIterative(nums, target, 0, nums.length - 1);
        }

        if (nums[pivot] == target) {
            return pivot;
        }

        if (nums[0] > target) {
            return binarySearchIterative(nums, target, pivot, nums.length - 1);
        } else {
            return binarySearchIterative(nums, target, 0, pivot);
        }
    }

    public static int find_rotate_index(int[] nums, int left, int right) {
        if (nums[left] < nums[right])
            return 0;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    private static int binarySearchIterative(int[] nums, int x, int left, int right) {
        while(left <= right) {
            int mid = left + ((right - left) / 2);

            if(x == nums[mid]) {
                return mid;
            } else if(x < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        //int[] nums = {3,1};

        System.out.println(search(nums, 1));
    }

}
