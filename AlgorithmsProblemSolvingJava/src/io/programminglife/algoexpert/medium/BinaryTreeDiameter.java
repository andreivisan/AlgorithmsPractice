package io.programminglife.algoexpert.medium;

public class BinaryTreeDiameter {

    int ans = 0;

    public int binaryTreeDiameter(BinaryTree tree) {
        maxDepth(tree);
        return ans;
    }

    public int maxDepth(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }

        int leftDepth = maxDepth(tree.left);
        int rightDepth = maxDepth(tree.right);

        ans = Math.max(ans, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
