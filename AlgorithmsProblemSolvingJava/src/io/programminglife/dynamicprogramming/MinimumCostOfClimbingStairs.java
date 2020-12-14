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

    public int minCostClimbingStairsRec(int[] cost) {
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

    public int minCostClimbingStairsIter(int[] cost) {
        int n = cost.length;
        int minCost[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                minCost[i] = cost[i];
            } else {
                minCost[i] = cost[i] + Math.min(minCost[i - 1], minCost[i - 2]);
            }
        }

        return Math.min(minCost[n - 1], minCost[n - 2]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return cost[0];
        }

        int last = cost[1];
        int secondToLast = cost[0];
        
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(last, secondToLast);
            secondToLast = last;
            last = current;
        }

        return Math.min(last, secondToLast);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};

        System.out.println(new MinimumCostOfClimbingStairs().minCostClimbingStairs(cost));
    }

}
