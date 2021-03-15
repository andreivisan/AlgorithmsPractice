package io.programminglife.algoexpert.medium;

public class KthLargestValueInBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int visited;
        public int kthValue;

        public TreeInfo(int visited, int kthValue) {
            this.visited = visited;
            this.kthValue = kthValue;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        TreeInfo ti = new TreeInfo(0, -1);
        reverseInOrder(tree, k, ti);
        //System.out.println(kthMax);
        return ti.kthValue;
    }

    public void reverseInOrder(BST tree, int k, TreeInfo ti) {
        if (tree == null || ti.visited >= k) {
            return;
        }

        reverseInOrder(tree.right, k, ti);
        if (ti.visited < k) {
            ti.visited += 1;
            ti.kthValue = tree.value;
            reverseInOrder(tree.left, k, ti);
        }
    }

}
