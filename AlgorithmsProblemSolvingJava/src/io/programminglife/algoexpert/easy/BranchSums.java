package io.programminglife.algoexpert.easy;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        sum(root, result, 0);
        
        return result;
    }
	
	private static void sum(BinaryTree root, List<Integer> result, int sum) {
		if (root == null) {
			return;
		}
		
		sum += root.value;
		if (root.left == null && root.right == null) {
			result.add(sum);
			return;
		}
		
		sum(root.left, result, sum);
		sum(root.right, result, sum);
	}
}
