package io.programminglife.recursion;

public class Fibonacci {

    public static int findFibonacci(int n) {
        if(n < 2) {
            return n;
        }

        return findFibonacci(n - 1) + findFibonacci(n - 2);
    }

    public static void main(String[] args) {
        int fibonacci = findFibonacci(5);

        System.out.println(fibonacci);
    }
    
}