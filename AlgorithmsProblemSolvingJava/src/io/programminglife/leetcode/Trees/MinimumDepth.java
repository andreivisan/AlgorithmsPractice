package io.programminglife.leetcode.Trees;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class MinimumDepth {

    public static int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();

        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair<>(root, 1));
        }

        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int currentDepth = current.getValue();

            if (root.left == null && root.right == null) {
                min = Math.min(currentDepth, min);
            }
            if(root.left != null) {
                stack.add(new Pair<TreeNode, Integer>(root.left, currentDepth + 1));
            }
            if(root.right != null) {
                stack.add(new Pair<TreeNode, Integer>(root.right, currentDepth + 1));
            }
        }

        return min;
    }

    public static int minDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepthRecursive(root.left), min);
        }

        if (root.right != null) {
            min = Math.min(minDepthRecursive(root.right), min);
        }

        return min + 1;
    }

}
