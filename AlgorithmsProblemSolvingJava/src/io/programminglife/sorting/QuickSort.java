package io.programminglife.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Select the last element as pivot
 * Instantiate i to left, iterate over j
 * If element at j is less than pivot swap with element at i
 * When element at j is the pivot swap with element at i
 */
public class QuickSort {

    public static int[] sort(int[] input, int left, int right) {
        if (left < right) {
            int partitionIdx = partition(input, left, right);
            sort(input, left, partitionIdx - 1);
            sort(input, partitionIdx + 1, right);
        }

        return input;
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

    public static void main(String[] args) {
        int[] input = {3,2,3,1,2,4,5,5,6};

        int[] sorted = sort(input, 0, input.length-1);

        for (int i : sorted) {
            System.out.print(i + " ");
        }
    }

}
