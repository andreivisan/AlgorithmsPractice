package io.programminglife.leetcode.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {
    LinkedList<String> itinerary = new LinkedList<>();
    Map<String, PriorityQueue<String>> graph = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        graph = createGraph(tickets);

        visit("JFK");

        return itinerary;
    }

    private Map<String, PriorityQueue<String>> createGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            if (!graph.containsKey(ticket.get(0))) {
                graph.put(ticket.get(0), new PriorityQueue<>());
            }

            graph.get(ticket.get(0)).offer(ticket.get(1));
        }

        return graph;
    }

    private void visit(String from) {
        while (graph.containsKey(from) && !graph.get(from).isEmpty()) {
            visit(graph.get(from).poll());
        }
        itinerary.addFirst(from);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO"));

        List<String> itinerary = new ReconstructItinerary().findItinerary(tickets);
        itinerary.forEach(System.out::println);
    }

}
