package io.programminglife.algoexpert.medium;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        int globalMaxPeak = 0;
        int index = 1;

        while (index < array.length - 1) {
            boolean isPeak = array[index - 1] < array[index] && array[index] > array[index + 1];
            if (!isPeak) {
                index += 1;
                continue;
            }

            int leftIndex = index - 2;
            while (leftIndex >=0 && array[leftIndex] < array[leftIndex + 1]) {
                leftIndex-=1;
            }

            int rightIndex = index + 2;
            while (rightIndex < array.length && array[rightIndex] < array[rightIndex - 1]) {
                rightIndex+=1;
            }

            int currentMaxPeak = rightIndex - leftIndex - 1;
            if (currentMaxPeak > globalMaxPeak) {
                globalMaxPeak = currentMaxPeak;
            }

            index = rightIndex;
        }

        return globalMaxPeak;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};

        System.out.println(longestPeak(array));
    }
}
