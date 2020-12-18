package io.programminglife.algoexpert.easy;

public class NodeDepthsSum {
    	
	static int resultSum;

    public static int nodeDepths(BinaryTree root) {
        resultSum = 0;
        sum(root, 0);
          
        return resultSum;
    }
      
    private static void sum(BinaryTree root, int depth) {
        if (root == null) {
            return;
        }
        
        resultSum = resultSum + depth;
        System.out.println("sum = "+ resultSum);
        
        if (root.left == null && root.right == null) {
            depth = 0;
            return;
        }
        
        sum(root.left, depth + 1);
        sum(root.right, depth + 1);
    }
  
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
