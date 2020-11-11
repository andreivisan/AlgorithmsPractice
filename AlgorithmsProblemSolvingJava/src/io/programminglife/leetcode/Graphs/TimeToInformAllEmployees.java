package io.programminglife.leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeToInformAllEmployees {

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int e = 0; e < manager.length; e++) {
            if (!adjList.containsKey(manager[e])) {
                adjList.put(manager[e], new ArrayList<>());
            }
            adjList.get(manager[e]).add(e);
        }

        return dfs(headID, adjList, informTime);
    }

    public static int dfs(int currentId, Map<Integer, List<Integer>> adjList, int[] informTime) {
        if (!adjList.containsKey(currentId)) {
            return 0;
        }

        int max = 0;
        List<Integer> subordinates = adjList.get(currentId);
        for (Integer subordinate : subordinates) {
            max = Math.max(max, dfs(subordinate, adjList, informTime));
        }

        return max + informTime[currentId];
    }

    public static void main(String[] args) {
        int[] managers = {2, 2, 4, 6, -1, 4, 4, 5};
        int[] informTime ={0, 0, 4, 0, 7, 3, 6, 0};

        System.out.println(numOfMinutes(8, 4, managers, informTime));
    }

}
