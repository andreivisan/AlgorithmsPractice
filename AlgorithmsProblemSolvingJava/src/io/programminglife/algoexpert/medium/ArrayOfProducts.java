package io.programminglife.algoexpert.medium;

public class ArrayOfProducts {

    public int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];
        int[] leftProductsArray = new int[array.length];
        int[] rightProductsArray = new int[array.length];

        int currentLeftProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftProductsArray[i] = currentLeftProduct;
            currentLeftProduct *= array[i];
        }

        int currentRightProduct = 1;
        for (int i = array.length - 1; i > 0; i--) {
            rightProductsArray[i] = currentRightProduct;
            currentRightProduct *= array[i];
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = leftProductsArray[i] * rightProductsArray[i];
        }

        return result;
    }

}
