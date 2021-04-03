package io.programminglife.youtube;

public class MinCostOfClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
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
        int[] cost = { 10, 15, 20 };

        System.out.println(minCostClimbingStairs(cost));
    }
}
