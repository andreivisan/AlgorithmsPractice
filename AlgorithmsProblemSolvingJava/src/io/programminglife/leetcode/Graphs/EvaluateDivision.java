package io.programminglife.leetcode.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answer = new double[queries.size()];
        Map<String, HashMap<String, Double>> graph = createGraph(equations, values);

        for (int i = 0; i < queries.size(); i++) {
            answer[i] = calculate(graph, queries.get(i));
        }

        return answer;
    }

    private Map<String, HashMap<String, Double>> createGraph(List<List<String>> equations, double[] values) {
        Map<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String divided  = equations.get(i).get(0);
            String divisor  = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(divided, k -> new HashMap<>());
            graph.computeIfAbsent(divisor, k -> new HashMap<>());

            graph.get(divided).put(divisor, value);
            graph.get(divisor).put(divided, 1/value);
        }

        return graph;
    }

    private double calculate(Map<String, HashMap<String, Double>> graph, List<String> query) {
        String source = query.get(0);
        String destination = query.get(1);

        if (!graph.containsKey(source) || !graph.containsKey(destination)) {
            return -1;
        }

        if (source.equals(destination)) {
            return 1;
        }

        Queue<HashMap<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new HashMap<String, Double>() {
            {
                put(source, 1d);
            }
        });
        visited.add(source);

        while (!queue.isEmpty()) {
            HashMap<String, Double> currentPair = queue.poll();
            String currentNode = (String)currentPair.keySet().toArray()[0];
            Double currentValue = currentPair.get(currentNode);

            if (currentNode.equals(destination)) {
                return currentValue;
            }

            HashMap<String, Double> adjList = graph.get(currentNode);
            for (String divisor : adjList.keySet()) {
                if (!visited.contains(divisor)) {
                    queue.offer(new HashMap<String, Double>() {
                        {
                            put(divisor, currentValue * adjList.get(divisor));
                        }
                    });
                    visited.add(divisor);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));

        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(equations, values, queries)));

    }

}
