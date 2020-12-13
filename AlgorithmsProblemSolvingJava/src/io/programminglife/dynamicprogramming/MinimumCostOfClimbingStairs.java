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

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};

        System.out.println(new MinimumCostOfClimbingStairs().minCostClimbingStairsBrute(cost));
    }

}
