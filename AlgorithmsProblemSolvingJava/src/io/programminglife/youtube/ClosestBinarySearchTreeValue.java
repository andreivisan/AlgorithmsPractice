package io.programminglife.youtube;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        return findClosestValue(root, target, Double.MAX_VALUE, root.val);
     }
     
     private static int findClosestValue(TreeNode tree, double target, double diff, int currentClosest){
         if (tree == null) {
             return currentClosest;
         }
         
         if (Math.abs(target - tree.val) < diff) {
            diff = Math.abs(target - tree.val);
            currentClosest = tree.val;
         }
         
         if (target > tree.val) {
             return findClosestValue(tree.right, target, diff, currentClosest);
         } else {
             return findClosestValue(tree.left, target, diff, currentClosest);
         }
     }

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
}
