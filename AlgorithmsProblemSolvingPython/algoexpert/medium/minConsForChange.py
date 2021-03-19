def minNumberOfCoinsForChange(n, denoms):
    number_of_coins = [float("inf") for amount in range(n + 1)]
    number_of_coins[0] = 0

    for denom in denoms:
        for amount in range(n + 1):
            if denom <= amount:
                number_of_coins[amount] = min(
                    number_of_coins[amount], number_of_coins[amount - denom] + 1)

    return number_of_coins[n] if number_of_coins[n] != float("inf") else -1
