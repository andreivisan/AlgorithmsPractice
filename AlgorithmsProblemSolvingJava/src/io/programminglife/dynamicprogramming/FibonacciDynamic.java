package io.programminglife.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamic {

    static int calculations = 0;

    public static int findFibonacci(int n) {
        if(n < 2) {
            return n;
        }

        return findFibonacci(n - 1) + findFibonacci(n - 2);
    }

    public static int fibonacciMaster(Map<Integer, Integer> cache, int n) {
        calculations++;
        if(cache.keySet().contains(n)) {
            return cache.get(n);
        } else {
            if(n < 2) {
                return n;
            } else {
                cache.put(n, fibonacciMaster(cache, n - 1) + fibonacciMaster(cache, n - 2));
                return cache.get(n);
            }
        }
    }

    public static int fib(int N) {
        int[] cache = new int[N+1];
        if(N == 0) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        if(N >= 2) {
            for(int i = 2; i <= N; i++) {
                cache[i] = cache[i - 2] + cache[i - 1];
            }
        }
        return cache[N];
    }

    public static void main(String[] args) {
        int fibonacci = fibonacciMaster(new HashMap<>(), 30);
        int fibonacci2 = fib(0);

        System.out.println(fibonacci2);
    }

}
