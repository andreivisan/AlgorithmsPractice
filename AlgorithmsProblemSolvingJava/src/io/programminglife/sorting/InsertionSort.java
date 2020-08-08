package io.programminglife.sorting;

public class InsertionSort {

    private static int[] insertionSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j -1;
            }
            nums[j + 1] = key;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 7, 5, 6, 8, 4, 2};

        int[] sortedNums = insertionSort(nums);

        for(int i = 0; i < sortedNums.length; i++) {
            System.out.println(sortedNums[i] + " ");
        }
    }

}
