package io.programminglife.algoexpert.easy;

import java.util.Arrays;

public class MinimumWaitingTime {

    public static int minimumWaitingTime(int[] queries) {
        int sum = 0;

        Arrays.sort(queries);

        for (int i = 0; i < queries.length; i++) {
            int queriesLeft = queries.length - (i + 1);
            sum += queries[i] * queriesLeft;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};

        System.out.println(minimumWaitingTime(queries));
    }

}
