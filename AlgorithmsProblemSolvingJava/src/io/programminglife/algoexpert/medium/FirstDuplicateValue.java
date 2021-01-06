package io.programminglife.algoexpert.medium;

public class FirstDuplicateValue {

    public static int firstDuplicateValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = Math.abs(array[i]) - 1;
            if (array[pos] < 0) {
                return Math.abs(array[i]);
            }
            array[pos] *= -1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2,1,5,2,3,3,4};

        System.out.println(firstDuplicateValue(array));
    }

}
