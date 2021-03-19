def numberOfWaysToMakeChange(n, denoms):
    ways = [0 for amount in range(n + 1)]
    ways[0] = 1

    for coin in denoms:
        for amount in range(1, n + 1):
            if coin <= amount:
                ways[amount] += ways[amount - coin]

    return ways[n]
