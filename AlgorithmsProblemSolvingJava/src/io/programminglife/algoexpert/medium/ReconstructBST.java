package io.programminglife.algoexpert.medium;

import java.util.ArrayList;

public class ReconstructBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int rootIdx;

        public TreeInfo(int rootIndex) {
            this.rootIdx = rootIndex;
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBstRec(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }

    public BST reconstructBstRec(int lowerBound, int upperBound, ArrayList<Integer> preOrderTraversalValues,
            TreeInfo treeInfo) {
        if (preOrderTraversalValues.size() == treeInfo.rootIdx) {
            return null;
        }

        int rootValue = preOrderTraversalValues.get(treeInfo.rootIdx);
        if (rootValue < lowerBound || rootValue >= upperBound) {
            return null;
        }

        treeInfo.rootIdx += 1;
        BST leftSubtree = reconstructBstRec(lowerBound, rootValue, preOrderTraversalValues, treeInfo);
        BST rightSubtree = reconstructBstRec(rootValue, upperBound, preOrderTraversalValues, treeInfo);

        BST root = new BST(rootValue);
        root.left = leftSubtree;
        root.right = rightSubtree;

        return root;
    }

}
