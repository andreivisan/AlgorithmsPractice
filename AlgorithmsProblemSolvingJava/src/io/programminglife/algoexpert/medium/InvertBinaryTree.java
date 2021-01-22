package io.programminglife.algoexpert.medium;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) {
            return;
        }

        swap(tree);

        invertBinaryTree(tree.right);
        invertBinaryTree(tree.left);
    }

    public static void invertBinaryTreeIterative(BinaryTree tree) {
        if (tree == null) {
            return;
        }

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            swap(current);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    private static void swap(BinaryTree tree) {
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
