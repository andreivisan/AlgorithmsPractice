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
}
