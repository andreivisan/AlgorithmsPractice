package io.programminglife.algoexpert.medium;

public class MinCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            ways[i] = Integer.MAX_VALUE;
        }

        ways[0] = 0;
        int toCompare = 0;

        for (int coin : denoms) {
            for (int amount = 0; amount < n + 1; amount++) {
                if (coin <= amount) {
                    if (ways[amount - coin] == Integer.MAX_VALUE) {
                        toCompare = Integer.MAX_VALUE;
                    } else {
                        toCompare = ways[amount - coin] + 1;
                    }
                    ways[amount] = Math.min(ways[amount], toCompare);
                }
            }
        }

        return ways[n] == Integer.MAX_VALUE ? -1 : ways[n];
    }
}
