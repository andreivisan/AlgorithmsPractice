package io.programminglife.sorting;

public class SelectionSort {

    public static int[] selectionSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int pos = i;
            for(int j = i + 1; j < nums.length; j++) {
                if(min > nums[j]) {
                    pos = j;
                    min = nums[j];
                }
            }

            int temp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 7, 5, 6, 8, 4, 2};

        int[] sortedNums = selectionSort(nums);

        for(int i = 0; i < sortedNums.length; i++) {
            System.out.println(sortedNums[i] + " ");
        }
    }

}
