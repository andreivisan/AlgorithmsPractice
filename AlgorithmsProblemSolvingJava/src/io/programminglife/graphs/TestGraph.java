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
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Bob");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Rob", "Maria");
        graph.addEdge("Mark", "Alice");

        return graph;
    }

    public static void main(String[] args) {
        Graph<String> graph = createGraph();

        System.out.println(graph.hasPathDFS("Bob", "Rob", new LinkedHashSet<>())); 

        System.out.println(graph.hasPathDFSIterative("Mark", "Bob")); 
        System.out.println(graph.hasPathBFS("Mark", "Maria")); 
    }
    
}
