def minCostClimbingStairs(cost):
    n = len(cost)

    if n == 0:
        return 0

    if n == 1:
        return cost[0]

    last = cost[1]
    second_to_last = cost[0]

    for i in range(2, n):
        current = cost[i] + min(last, second_to_last)
        second_to_last = last
        last = current

    return min(last, second_to_last)


if __name__ == "__main__":
    cost = [10, 15, 20]
    print(minCostClimbingStairs(cost))
