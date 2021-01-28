package io.programminglife.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFindSuccessor {

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        List<BinaryTree> nodes = new ArrayList<>();
        inOrderTraverse(tree, nodes);

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).value == node.value && i < nodes.size() - 1) {
                return nodes.get(i + 1);
            }
        }

        return null;
    }

    private void inOrderTraverse(BinaryTree tree, List<BinaryTree> nodes) {
        if (tree == null) {
            return;
        }

        inOrderTraverse(tree.left, nodes);
        nodes.add(tree);
        inOrderTraverse(tree.right, nodes);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
