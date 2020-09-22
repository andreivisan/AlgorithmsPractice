package io.programminglife.leetcode.Trees;

import javafx.util.Pair;

import java.util.LinkedList;

public class MaximumDepth {

    public int maxDepth(Node root) {
        LinkedList<Pair<Node, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair<>(root, 1));
        }

        int max = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> current = stack.poll();
            root = current.getKey();
            int currentMax = current.getValue();

            if (root != null) {
                max = Math.max(currentMax, max);
                for (Node node : root.children) {
                    stack.add(new Pair<>(node, currentMax + 1));
                }
            }
        }

        return max;
    }

}
