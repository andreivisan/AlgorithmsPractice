package io.programminglife.sorting;

public class MergeSort {

    private int[] mergeSort(int[] input, int n) {
        if (n == 1) {
            return input;
        }

        int middle = n/2;

        int[] left = new int[middle];
        int[] right = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = input[i];
        }

        for (int i = middle; i < n; i++) {
            right[i - middle] = input[i];
        }

        mergeSort(left, middle);
        mergeSort(right, n-middle);

        return merge(input, left, right, middle, n - middle);
    }

    private int[] merge(int[] input, int[] left, int[] right, int l, int r) {
        int i = 0, j = 0, k = 0;

        while (i < l && j < r) {
            if (left[i] <= right[j]) {
                input[k] = left[i];
                i++;
            } else {
                input[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < l) {
            input[k++] = left[i++];
        }

        while (j < r) {
            input[k++] = right[j++];
        }

        return input;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] input = {5, 4, 3, 2, 1};

        for (int j = 0; j < n; j++) {
            System.out.print(new MergeSort().mergeSort(input, n)[j] + " ");
        }

    }

}
