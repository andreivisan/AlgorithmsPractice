package io.programminglife.sorting;

public class BubbleSort {

    public static int[] bubbleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 7, 5, 6, 8, 4, 2};

        int[] sortedNums = bubbleSort(nums);

        for(int i = 0; i < sortedNums.length; i++) {
            System.out.println(sortedNums[i] + " ");
        }
    }

}
