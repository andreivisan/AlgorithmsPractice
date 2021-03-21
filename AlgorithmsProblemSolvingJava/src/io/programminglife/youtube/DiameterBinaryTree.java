package io.programminglife.youtube;

public class DiameterBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    public int maxDepth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }

        int leftDepth = maxDepth(tree.left);
        int rightDepth = maxDepth(tree.right);

        ans = Math.max(ans, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
