package io.programminglife.leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    Map<Node, Node> dfsVisited = new HashMap<>();

    public Node cloneGraphBFS(Node node) {
        Map<Node, Node> visited = new HashMap<>();

        if (node == null) {
            return node;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }

    public Node cloneGraphDFS(Node node) {
        if (node == null) {
            return node;
        }

        if (dfsVisited.containsKey(node)) {
            return dfsVisited.get(node);
        }

        Node clonedNode = new Node(node.val, new ArrayList<>());
        dfsVisited.put(node, clonedNode);

        for (Node neighbor: node.neighbors) {
            clonedNode.neighbors.add(cloneGraphDFS(neighbor));
        }

        return clonedNode;
    }

}
