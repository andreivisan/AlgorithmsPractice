package io.programminglife.leetcode.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * 
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 */
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