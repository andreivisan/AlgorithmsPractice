package io.programminglife.leetcode.Trees;

import io.programminglife.trees.BinarySearchTree;
import io.programminglife.trees.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise,
 * the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * Note: The merging process must start from the root nodes of both trees.
 */
public class MergeTwoBinaryTrees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{t1, t2});

        while (!queue.isEmpty()) {
           TreeNode[] nodes = queue.remove();
           if (nodes[0] == null || nodes[1] == null) {
               continue;
           }

           nodes[0].val += nodes[1].val;

           if (nodes[0].left == null) {
               nodes[0].left = nodes[1].left;
           } else {
               queue.add(new TreeNode[] {nodes[0].left, nodes[1].left});
           }

            if (nodes[0].right == null) {
                nodes[0].right = nodes[1].right;
            } else {
                queue.add(new TreeNode[] {nodes[0].right, nodes[1].right});
            }
        }

        return t1;
    }

    public static void main(String[] args) {
        Integer[] input1 = {10,5,15,3,7,null,18};
        Integer[] input2 = {10,5,15,3,7,null,18};
        BinarySearchTree bst1 = new BinarySearchTree();
        BinarySearchTree bst2 = new BinarySearchTree();

        for (Integer integer : input1) {
            bst1.addNode(integer);
        }

        for (Integer integer : input2) {
            bst2.addNode(integer);
        }

    }

}
