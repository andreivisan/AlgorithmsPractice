def contains_nearby_duplicate(nums, k):
    if k <= 0:
        return False

    lookup = {}

    for index, number in enumerate(nums):
        if number in lookup and index - lookup[number] <= k:
            return True
        lookup[number] = index

    return False

print(contains_nearby_duplicate([1,2,3,1,2,3], 2))