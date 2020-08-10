def kidsWithCandies(candies, extraCandies):
    M = max(candies)
    return [candy + extraCandies >= M for candy in candies]

print(kidsWithCandies([2,3,5,1,3], 3))