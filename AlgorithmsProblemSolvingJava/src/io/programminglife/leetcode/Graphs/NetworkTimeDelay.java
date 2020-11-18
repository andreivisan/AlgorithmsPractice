package io.programminglife.leetcode.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkTimeDelay {

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = createGraph(times);
        Map<Integer, Integer> distances = initializeDistances(N);
        PriorityQueue<Integer> heap = new PriorityQueue<>((v1, v2) -> distances.get(v1) - distances.get(v2));

        distances.put(K, 0);
        heap.offer(K);

        while (!heap.isEmpty()) {
            int current = heap.poll();
            List<int[]> currentAdjList = graph.get(current);

            if (currentAdjList != null) {
                for (int[] neighbor : currentAdjList) {
                    int neighboringNode = neighbor[0];
                    int neighborWeight = neighbor[1];

                    if (distances.get(current) + neighborWeight < distances.get(neighboringNode)) {
                        distances.put(neighboringNode, distances.get(current) + neighborWeight);
                        heap.offer(neighboringNode);
                    }
                }
            }
        }

        int ans = Collections.max(distances.values());

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private Map<Integer, List<int[]>> createGraph(int[][] times) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            int source = times[i][0];
            int neighbor = times[i][1];
            int weight = times[i][2];
            if (!graph.containsKey(source)) {
                graph.put(source, new ArrayList<>());
            }
            graph.get(source).add(new int[]{neighbor, weight});
        }

        return graph;
    }

    private Map<Integer, Integer> initializeDistances(int N) {
        Map<Integer, Integer> distances = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }

        return distances;
    }
}
