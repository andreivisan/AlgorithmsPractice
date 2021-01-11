package io.programminglife.algoexpert.medium;

import java.util.List;
import java.util.Stack;

public class BSTTraversal {

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }

        inOrderTraverse(tree.left, array);

        array.add(tree.value);

        inOrderTraverse(tree.right, array);

        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }

        array.add(tree.value);

        preOrderTraverse(tree.left, array);

        preOrderTraverse(tree.right, array);

        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }

        postOrderTraverse(tree.left, array);

        postOrderTraverse(tree.right, array);

        array.add(tree.value);

        return array;
    }

    public static List<Integer> inOrderTraverseIterative(BST tree, List<Integer> array) {
        Stack<BST> stack = new Stack<>();

        BST current = tree;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                array.add(current.value);
                current = current.right;
            }
        }

        return array;
    }

    public static List<Integer> preOrderTraverseIterative(BST tree, List<Integer> array) {
        Stack<BST> stack = new Stack<>();

        BST root = tree;
        stack.push(root);

        while (!stack.isEmpty()) {
            BST current = stack.pop();
            array.add(current.value);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return array;
    }

    public static List<Integer> postOrderTraverseIterative(BST tree, List<Integer> array) {
        Stack<BST> stack = new Stack<>();

        BST root = tree;
        stack.push(root);

        while (!stack.isEmpty()) {
            BST current = stack.pop();
            array.add(0, current.value);

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
