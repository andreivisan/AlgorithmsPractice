package io.programminglife.leetcode.Recursion;

public class Tribonacci {

    static int[] tn = new int[38];

    public static int tribonacci(int n) {
        if (tn[n] > 0) return tn[n];

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        return tn[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }

}
