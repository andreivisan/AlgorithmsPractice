package io.programminglife.leetcode.Trees;

import io.programminglife.trees.BinarySearchTree;
import io.programminglife.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null) {
                queue.add(current.left);
            }

            if(current.right != null) {
                queue.add(current.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree bst1 = new BinarySearchTree();

        bst1.addNode(4);
        bst1.addNode(2);
        bst1.addNode(7);
        bst1.addNode(1);
        bst1.addNode(3);
        bst1.addNode(6);
        bst1.addNode(9);

        bst1.preOrderTraverseTree(bst1.root);
        System.out.println("=================");
        bst1.preOrderTraverseTree(invertTree(bst1.root));
    }

}
