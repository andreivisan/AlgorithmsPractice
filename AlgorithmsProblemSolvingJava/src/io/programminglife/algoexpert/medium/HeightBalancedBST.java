package io.programminglife.algoexpert.medium;

public class HeightBalancedBST {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int height;
        public boolean isBalanced;

        public TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.isBalanced;
    }

    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(-1, true);
        }

        TreeInfo leftSubtreeInfo = getTreeInfo(tree.left);
        TreeInfo rightSubtreeInfo = getTreeInfo(tree.right);

        boolean isBalanced = leftSubtreeInfo.isBalanced && rightSubtreeInfo.isBalanced
                && Math.abs(leftSubtreeInfo.height - rightSubtreeInfo.height) <= 1;
        int height = Math.max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1;

        return new TreeInfo(height, isBalanced);
    }
}
