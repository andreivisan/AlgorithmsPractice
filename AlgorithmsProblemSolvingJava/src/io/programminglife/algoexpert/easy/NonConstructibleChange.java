package io.programminglife.algoexpert.easy;

import java.util.Arrays;

public class NonConstructibleChange {

    public static int nonConstructibleChange(int[] coins) {
        if (coins.length == 0) {
            return 1;
        }

        Arrays.sort(coins);

        int change = 0;
        for (int coin : coins) {
            if (coin > change + 1) {
                return change + 1;
            }
            change += coin;
        }

        return change + 1;
    }

    public static void main(String[] args) {
        int[] coins = {5,7,1,1,2,3,22};

        System.out.println(nonConstructibleChange(coins));
    }

}
