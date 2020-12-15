package io.programminglife.dynamicprogramming;

import java.text.DecimalFormat;

public class KnightProbabilityInChessboard {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    private int[][] directions = {
        {-2, -1},
        {-2, 1},
        {-1, 2},
        {1, 2},
        {2, 1},
        {2, -1},
        {1, -2},
        {-1, -2}
    };

    public double knightProbabilityBruteRec(int N, int K, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }

        if (K == 0) {
            return 1;
        }

        double result = 0;
        for (int i = 0; i < directions.length; i++) {
            int[] direction = directions[i];
            result = result + knightProbabilityBruteRec(N, K - 1, r + direction[0], c + direction[1])/8;
        }

        return result;
    }

    public double knightProbabilityDPRec(int N, int K, int r, int c) {
        double [][][] dp = new double[K+1][N][N];

        return DPRecursion(N, K, r, c, dp);
    }

    private double DPRecursion(int N, int K, int r, int c, double[][][] dp) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }

        if (K == 0) {
            return 1;
        }

        if (dp[K][r][c] > 0) {
            return dp[K][r][c];
        }

        double result = 0;
        for (int i = 0; i < directions.length; i++) {
            int[] direction = directions[i];
            result = result + DPRecursion(N, K - 1, r + direction[0], c + direction[1], dp)/8;
        }

        dp[K][r][c] = result;
        return dp[K][r][c];
    }

    public static void main(String[] args) {
        System.out.println(new KnightProbabilityInChessboard().knightProbabilityDPRec(3, 2, 0, 0));
    }
}
