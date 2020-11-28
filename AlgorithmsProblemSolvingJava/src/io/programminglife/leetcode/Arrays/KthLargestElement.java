package io.programminglife.leetcode.Arrays;

import io.programminglife.sorting.QuickSort;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargestNaive(int[] nums, int k) {
        return QuickSort.sort(nums, 0, nums.length-1)[nums.length - k];
    }

    //We use more memory by using a PriorityQueue
    public int findKthLargestMemoryCompromise(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }

    public int findKthLargestHoares(int[] nums, int k) {
        int size = nums.length;
        return quickselect(nums, 0, size-1, size-k);
    }

    private int quickselect(int[] input, int left, int right, int indexToFind) {
        if (left == right) {
            return input[left];
        }

        int partitionIdx = partition(input, left, right);
        if (partitionIdx == indexToFind) {
            return input[partitionIdx];
        } else if (partitionIdx < indexToFind) {
            return quickselect(input, partitionIdx + 1, right, indexToFind);
        } else {
            return quickselect(input, left, partitionIdx - 1, indexToFind);
        }
    }

    private static int partition(int[] input, int left, int right) {
        int pivot = input[right];
        int partitionIdx = left;

        for (int j = left; j < right; j++) {
            if (input[j] < pivot) {
                swap(input, partitionIdx, j);
                partitionIdx++;
            }
        }

        swap(input, partitionIdx, right);

        return partitionIdx;
    }

    private static void swap(int[] input, int firstIdx, int secondIdx) {
        int temp = input[firstIdx];
        input[firstIdx] = input[secondIdx];
        input[secondIdx] = temp;
    }
}
