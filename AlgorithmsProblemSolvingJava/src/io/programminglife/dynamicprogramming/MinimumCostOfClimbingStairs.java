package io.programminglife.dynamicprogramming;

public class MinimumCostOfClimbingStairs {
    
    public int minCostClimbingStairsBrute(int[] cost) {
        int n = cost.length;

        return Math.min(minCostBrute(n - 1, cost), minCostBrute(n - 2, cost));
    }

    private int minCostBrute(int i, int[] cost) {
        if (i < 0) {
            return 0;
        }

        if (i <= 1) {
            return cost[i];
        }

        return cost[i] + Math.min(minCostBrute(i - 1, cost), minCostBrute(i - 2, cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] mins = new int[n];
        
        for (int i = 0; i < n; i++) {
            mins[i] = -1;
        }

        return Math.min(minCost(n - 1, cost, mins), minCost(n - 2, cost, mins));
    }

    public int minCost(int i, int[] cost, int[] mins) {
        if (i < 0) {
            return 0;
        }

        if (i <= 1) {
            return cost[i];
        }

        if (mins[i] == -1) {
            mins[i] = cost[i] + Math.min(minCost(i - 1, cost, mins), minCost(i - 2, cost, mins));
        }

        return mins[i];
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};

        System.out.println(new MinimumCostOfClimbingStairs().minCostClimbingStairs(cost));
    }

}
