package io.programminglife.leetcode.Arrays;

public class BestBuySellStock {
    
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxDiff = 0;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if(prices[i] - minPrice > maxDiff) {
                maxDiff = prices[i] - minPrice;
            }
        }
        
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));
    }
    
}