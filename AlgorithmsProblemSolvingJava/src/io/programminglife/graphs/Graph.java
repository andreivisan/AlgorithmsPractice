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

    public Node<T> getNode(T label) {
        return lookup.get(label);
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

    public Set<Node<T>> dfsTraversalIterative(T label) {
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

    public Set<Node<T>> dfsTraversalRecursive(T label, LinkedHashSet<Node<T>> visited) {
        Node<T> start = lookup.getOrDefault(label, null);

        if (start == null) {
            return null;
        }

        visited.add(start);

        for (Node<T> node : start.adjacencyList) {
            if (!visited.contains(node)) {
                dfsTraversalRecursive(node.getLabel(), visited);
            }
        }

        return visited;
    }

    public boolean hasPathDFS(T sourceLabel, T destinationLabel, LinkedHashSet<Node<T>> visited) {
        Node<T> source = lookup.getOrDefault(sourceLabel, null);
        Node<T> destination = lookup.getOrDefault(destinationLabel, null);

        if (source == null || destination == null) {
            return false;
        }

        if (visited.contains(source)) {
            return false;
        }

        visited.add(source);

        if (source == destination) {
            return true;
        }

        for (Node<T> node : source.adjacencyList) {
            if (hasPathDFS(node.getLabel(), destination.getLabel(), visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasPathDFSIterative(T sourceLabel, T destinationLabel) {
        Node<T> source = lookup.getOrDefault(sourceLabel, null);
        Node<T> destination = lookup.getOrDefault(destinationLabel, null);

        if (source == null || destination == null) {
            return false;
        }

        LinkedHashSet<Node<T>> visited = new LinkedHashSet<>();
        Stack<Node<T>> stack = new Stack<>();

        stack.add(source);

        while (!stack.isEmpty()) {
            Node<T> currentNode = stack.pop();

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);

                if (currentNode == destination) {
                    return true;
                }
                
                for (Node<T> node : currentNode.adjacencyList) {
                    stack.add(node);
                }
            }
        }

        return false;
    }

    public Set<Node<T>> bfsTraversalIterative(T label) {
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

    public boolean hasPathBFS(T sourceLabel, T destinationLabel) {
        Node<T> source = lookup.getOrDefault(sourceLabel, null);
        Node<T> destination = lookup.getOrDefault(destinationLabel, null);

        if (source == null || destination == null) {
            return false;
        }

        Set<Node<T>> visited = new LinkedHashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();

        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.poll();
            if (currentNode == destination) {
                return true;
            }
            for (Node<T> node : currentNode.adjacencyList) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    queue.offer(node);
                }
            }
        }
        
        return false;
    }
    
}
