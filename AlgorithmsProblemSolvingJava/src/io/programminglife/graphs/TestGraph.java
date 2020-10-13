package io.programminglife.graphs;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import io.programminglife.graphs.Graph.Node;

public class TestGraph {

    private static Graph<String> createGraph() {
        Graph<String> graph = new Graph<>();

        graph.addNode("Bob");
        graph.addNode("Alice");
        graph.addNode("Mark");
        graph.addNode("Rob");
        graph.addNode("Maria");

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        return graph;
    }

    public static void main(String[] args) {
        Graph<String> graph = createGraph();

        System.out.println(graph);

        Set<Node<String>> dfs = graph.dfsTraversalIterative("Bob");

        System.out.print("Bob -> ");

        for (Node<String> node : dfs) {
            System.out.print(node.getLabel() + " ");
        }

        System.out.println(" ");

        Set<Node<String>> dfsRec = graph.dfsTraversalRecursive("Bob", new LinkedHashSet<Node<String>>());

        System.out.print("Bob -> ");

        for (Node<String> node : dfsRec) {
            System.out.print(node.getLabel() + " ");
        }

        System.out.println(" ");

        System.out.println(graph.hasPathDFS("Bob", "Rob", new LinkedHashSet<>()));
//        System.out.println(" ");
//
//        Set<Node<String>> bfs = graph.bfsTraversalIterative("Bob");
//
//        System.out.print("Bob -> ");
//
//        for (Node<String> node : bfs) {
//            System.out.print(node.getLabel() + " ");
//        }
    }
    
}
