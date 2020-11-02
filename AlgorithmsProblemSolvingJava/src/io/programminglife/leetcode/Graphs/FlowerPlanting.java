package io.programminglife.leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlowerPlanting {

    static class Garden {
        int[] flowerTypes = {1, 2, 3, 4};
        List<Garden> neighbours;
        int flower;

        public Garden() {
            neighbours = new ArrayList<>();
            flower = -1;
        }

        void distributeFlowers() {
            Set<Integer> distributedFlowers = new HashSet<>();

            for (Garden garden : neighbours) {
                if (garden.flower != -1) {
                    distributedFlowers.add(garden.flower);
                }
            }

            for (int flower : flowerTypes) {
                if (!distributedFlowers.contains(flower)) {
                    this.flower = flower;
                    break;
                }
            }
        }
    }

    public static int[] gardenNoAdj(int n, int[][] paths) {
        int[] answer = new int[n];
        Garden[] gardens = new Garden[n + 1];

        for (int i = 1; i < gardens.length; i++) {
            gardens[i] = new Garden();
        }

        for (int[] path : paths) {
            Garden garden1 = gardens[path[0]];
            Garden garden2 = gardens[path[1]];
            garden1.neighbours.add(garden2);
            garden2.neighbours.add(garden1);
        }

        for (int i = 1; i < gardens.length; i++) {
            gardens[i].distributeFlowers();
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = gardens[i + 1].flower;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
        //int[][] paths = {{1,2},{3,4}};
        int n = 4;

        int[] answer = gardenNoAdj(n, paths);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

}
