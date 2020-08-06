def max_profit(prices):
    i = 0
    valley = prices[0]
    peak = prices[0]
    max_profit = 0

    while(i < len(prices) - 1):
        while(i < len(prices) - 1 and prices[i] >= prices[i - 1]):
            i += 1
        valley = prices[i]

        while(i < len(prices) - 1 and prices[i] <= prices[i - 1]):
            i += 1
        peak = prices[i]

        max_profit += peak - valley

    return max_profit

print(max_profit([7,1,5,3,6,4]))