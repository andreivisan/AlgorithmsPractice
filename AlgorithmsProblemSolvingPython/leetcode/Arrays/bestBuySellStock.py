import math

def maxProfit(prices):
    min_price = math.inf
    max_profit = 0

    for i in range(len(prices)):
        if prices[i] < min_price:
            min_price = prices[i]
        if prices[i] - min_price > max_profit:
            max_profit = prices[i] - min_price

    return max_profit

print(maxProfit([7,1,5,3,6,4]))
