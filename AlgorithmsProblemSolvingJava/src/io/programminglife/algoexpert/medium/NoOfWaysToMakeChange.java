package io.programminglife.algoexpert.medium;

public class NoOfWaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int coin : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (coin <= amount) {
                    ways[amount] += ways[amount - coin];
                }
            }
        }

        return ways[n];
    }

}
