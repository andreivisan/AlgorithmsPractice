package io.programminglife.algoexpert.medium;

import java.util.Arrays;
import java.util.List;

public class MinHeightBST {


    public static BSTConstruction.BST minHeightBst(List<Integer> array) {
        return helper(array, 0, array.size() - 1);
    }

    private static BSTConstruction.BST helper(List<Integer> array, int startIdx, int endIdx) {
        if (endIdx < startIdx) {
            return null;
        }
        int midIdx = startIdx + (endIdx - startIdx)/2;
        BSTConstruction.BST tree = new BSTConstruction.BST(array.get(midIdx));
        tree.left = helper(array, startIdx, midIdx - 1);
        tree.right = helper(array, midIdx + 1, endIdx);

        return tree;
    }



    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        BSTConstruction.BST tree = minHeightBst(array);

        tree.print(tree);
    }

}
