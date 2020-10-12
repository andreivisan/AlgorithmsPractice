package io.programminglife.graphs;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<T> {

    public static class Node<T> {
        private T label;
        private LinkedList<Node<T>> adjacencyList = new LinkedList<>();

        public Node(T label) {
            this.label = label;
        }

        public LinkedList<Node<T>> getAdjacencyList() {
            return this.adjacencyList;
        }

        public T getLabel() {
            return this.label;
        }
    }

    private Map<T, Node<T>> lookup = new HashMap<>();

    public void addNode(T label) {
        Node<T> node = new Node<T>(label);
        lookup.putIfAbsent(label, node);
    }

    public void removeNode(T label) {
        Node<T> node = lookup.getOrDefault(label, null);
        if(node != null) {
            lookup.values().stream().forEach(v -> {
                v.getAdjacencyList().remove(node);
            });

            lookup.remove(node);
        }
    }

    public void addEdge(T label1, T label2) {
        Node<T> source = lookup.get(label1);
        Node<T> sink = lookup.get(label2);

        if (source != null && sink != null) {
            source.getAdjacencyList().push(sink);
            sink.getAdjacencyList().push(source);
        }
    }

    public void removeEdge(T label1, T label2) {
        Node<T> source = lookup.get(label1);
        Node<T> sink = lookup.get(label2);

        if (source != null && sink != null) {
            source.getAdjacencyList().remove(sink);
            sink.getAdjacencyList().remove(source);
        }
    }

    public Set<Node<T>> dfsTraversalIterative(String label) {
        if (lookup.isEmpty()) {
            return null;
        }
        Node<T> start = lookup.getOrDefault(label, null);
        
        if (start != null) {
            Set<Node<T>> visited = new LinkedHashSet<>();
            Stack<Node<T>> stack = new Stack<>();
            stack.push(start);

            while (!stack.isEmpty()) {
                Node<T> current = stack.pop();
                
                if (!visited.contains(current)) {
                    visited.add(current);

                    for (Node<T> node : current.adjacencyList) {
                        stack.push(node);
                    }
                }
            }

            return visited;
        } else {
            return null;
        }
    }

    public Set<Node<T>> bfsTraversalIterative(String label) {
        if (lookup.isEmpty()) {
            return null;
        }
        Node<T> start = lookup.getOrDefault(label, null);

        if (start != null) {
            Set<Node<T>> visited = new LinkedHashSet<>();
            Queue<Node<T>> queue = new LinkedList<>();

            queue.offer(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                Node<T> current = queue.poll();
                for (Node<T> node : current.adjacencyList) {
                    if (!visited.contains(node)) {
                        visited.add(node);
                        queue.offer(node);
                    }
                }
            }

            return visited;
        } else {
            return null;
        }
    }
    
}
