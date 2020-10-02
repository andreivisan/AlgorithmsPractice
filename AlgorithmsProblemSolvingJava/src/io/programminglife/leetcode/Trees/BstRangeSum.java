package io.programminglife.leetcode.Trees;

import io.programminglife.trees.BinarySearchTree;
import io.programminglife.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root node of a binary search tree, return the sum
 * of values of all nodes with value between L and R (inclusive).
 * The binary search tree is guaranteed to have unique values.
 *
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 *
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 */
public class BstRangeSum {

    static int sum = 0;

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        int rangeSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();

            if (current.val >= L && current.val <= R) {
                rangeSum += current.val;
            }

            if (current.left != null && current.val > L) {
                queue.add(current.left);
            }

            if(current.right != null && current.val < R) {
                queue.add(current.right);
            }
        }

        return rangeSum;
    }

    public static int rangeSumBSTRecursive(TreeNode root, int L, int R) {
        if (root != null) {
            if (root.val >= L && root.val <= R) {
                sum += root.val;
            }

            if (root.val > L) {
                rangeSumBSTRecursive(root.left, L, R);
            }

            if (root.val < R) {
                rangeSumBSTRecursive(root.right, L, R);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Integer[] input = {10,5,15,3,7,null,18};
        BinarySearchTree bst = new BinarySearchTree();

        for (Integer integer : input) {
            bst.addNode(integer);
        }

        System.out.println(rangeSumBSTRecursive(bst.root, 7, 15));
    }

}
