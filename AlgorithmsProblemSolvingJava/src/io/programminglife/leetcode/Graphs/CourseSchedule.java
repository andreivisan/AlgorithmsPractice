package io.programminglife.leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule {

    Map<Integer, Integer> inDegree = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites.length == 0) {
            return true;
        } 

        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }

        Map<Integer, List<Integer>> courseDictionary = createCourseDictionary(prerequisites);

        // for (int i = 0; i < numCourses; i++) {
        //     if (isCyclic(i, courseDictionary)) {
        //         return false;
        //     }
        // }

        return !isCyclicTopological(numCourses, courseDictionary);
    }

    private Map<Integer, List<Integer>> createCourseDictionary(int[][] prerequisites) {
        Map<Integer, List<Integer>> courseDictionary = new HashMap<>();

        for (int v = 0; v < prerequisites.length; v++) {
            if (courseDictionary.containsKey(prerequisites[v][1])) {
                courseDictionary.get(prerequisites[v][1]).add(prerequisites[v][0]);
            } else {
                LinkedList<Integer> adjList = new LinkedList<>();
                adjList.add(prerequisites[v][0]);
                courseDictionary.put(prerequisites[v][1], adjList);
            }
            inDegree.put(prerequisites[v][0], inDegree.getOrDefault(prerequisites[v][0], 0) + 1);
        }

        return courseDictionary;
    }

    private boolean isCyclic(int startNode, Map<Integer, List<Integer>> courseDictionary) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < courseDictionary.getOrDefault(startNode, new ArrayList<>()).size(); i++) {
            queue.offer(courseDictionary.get(startNode).get(i));
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited.add(current);

            if (current == startNode) {
                return true;
            }

            List<Integer> currentAdjList = courseDictionary.getOrDefault(current, new ArrayList<>());
            for (int i = 0; i < currentAdjList.size(); i++) {
                int next = currentAdjList.get(i);
                if (!visited.contains(next)) {
                    queue.offer(next);
                }
            }
        }

        return false;
    }

    private boolean isCyclicTopological(int n, Map<Integer, List<Integer>> courseDictionary) {
        int count = 0;

        Stack<Integer> stack = new Stack<>();
        for (Integer key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                stack.push(key);
            }
        }

        while (!stack.isEmpty()) {
            int current = stack.pop();
            count++;

            List<Integer> currentAdjList = courseDictionary.get(current);
            if (currentAdjList != null) {
                for (Integer adj : currentAdjList) {
                    inDegree.put(adj, inDegree.get(adj) - 1);
                    if (inDegree.get(adj) == 0) {
                        stack.push(adj);
                    }
                }
            }
        }

        return count != n;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 1}, {2, 5}, {0, 3}, {4, 3}, {3, 5}, {4, 5}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        System.out.println(new CourseSchedule().canFinish(4, prerequisites3));
    }

}
