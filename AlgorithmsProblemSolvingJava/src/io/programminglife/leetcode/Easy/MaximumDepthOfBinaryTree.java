package io.programminglife.leetcode.Easy;

public class MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int max;
    public int maxDepth(TreeNode root) {
        max = 0;
        maxD(root, 0);
        
        return max;
    }
    
    private void maxD(TreeNode root, int sumDepths) {
        if (root == null) {
            return;
        }
        
        sumDepths = sumDepths + 1;
        if (root.left == null && root.right == null) {
            if (sumDepths > max) {
                max = sumDepths;
            }
        }
        
        maxD(root.left, sumDepths);
        maxD(root.right, sumDepths);
    }

}
