package io.programminglife.algoexpert.easy;

public class ClosestValueInBST {
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValue(tree, target, Integer.MAX_VALUE, tree.value);
    }
        
    private static int findClosestValue(BST tree, int target, int diff, int currentClosest) {
        if (tree == null) {
            return currentClosest;
        }
        
        if ( Math.abs(target - tree.value) < diff) {
                diff = Math.abs(target - tree.value);
                currentClosest = tree.value;
        }
        
        if (target > tree.value) {
            return findClosestValue(tree.right, target, diff, currentClosest);
        } else {
            return findClosestValue(tree.left, target, diff, currentClosest);
        }
    }
    
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
