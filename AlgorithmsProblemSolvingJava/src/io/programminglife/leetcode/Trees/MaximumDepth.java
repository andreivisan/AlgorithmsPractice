package io.programminglife.leetcode.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import io.programminglife.util.Pair;

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

    public int maxDepthRecursive(Node root) {

        if (root == null) {
            return 0;
        }

        if (root.children.isEmpty()) {
            return 1;
        }

        List<Integer> heights = new ArrayList<>();
        for (Node node : root.children) {
            heights.add(maxDepth(node));
        }

        return Collections.max(heights) + 1;

    }

}
