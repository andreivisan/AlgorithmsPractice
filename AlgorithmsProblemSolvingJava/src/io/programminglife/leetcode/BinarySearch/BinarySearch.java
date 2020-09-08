package io.programminglife.leetcode.BinarySearch;

public class BinarySearch {

    private static boolean binarySearchIterative(int[] nums, int x) {
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

    private static boolean binarySearchRecursive(int[] nums, int x, int left, int right) {
        if(left > right) {
            return false;
        }

        int mid = left + ((right - left) / 2);

        if(nums[mid] == x) {
            return true;
        } else if(x < nums[mid]) {
            return binarySearchRecursive(nums, x, left, mid -1);
        } else {
            return binarySearchRecursive(nums, x, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(binarySearchRecursive(nums, 5, 0, nums.length - 1));
        System.out.println(binarySearchIterative(nums, 8));
    }

}
