def numIdenticalPairs(nums):
    pairs_count = {}

    for index, value in enumerate(nums):
        if pairs_count.get(value):
            pairs_count[value] = pairs_count[value] + 1
        else:
            pairs_count[value] = 1

    number_of_pairs = 0

    for value in pairs_count.values():
        number_of_pairs += value * (value - 1)/2

    return int(number_of_pairs)

print(numIdenticalPairs([1,1,1,1]))