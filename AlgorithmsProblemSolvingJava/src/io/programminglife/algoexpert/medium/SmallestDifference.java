package io.programminglife.algoexpert.medium;

import java.util.Arrays;

public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[2];

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int index1 = 0, index2 = 0;
        int globalSmallest = Integer.MAX_VALUE, currentSmallest = Integer.MAX_VALUE;

        while (index1 < arrayOne.length && index2 < arrayTwo.length) {
            int first = arrayOne[index1];
            int second = arrayTwo[index2];

            if (first > second) {
                currentSmallest = first - second;
                index2++;
            } else if (first < second) {
                currentSmallest = second - first;
                index1++;
            } else if (first == second) {
                return new int[]{first, second};
            }

            if (currentSmallest < globalSmallest) {
                globalSmallest = currentSmallest;
                result = new int[]{first, second};
            }
        }

        return result;
    }
}
