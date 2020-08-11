def smallerNumbersThanCurrent(nums):
    count_map = {}
    result = []
    sorted_nums = sorted(nums)

    for i in range(len(sorted_nums)):
        if sorted_nums[i] not in count_map:
            count_map[sorted_nums[i]] = i

    for i in range(len(nums)):
        result.append(count_map[nums[i]])

    return result

print("\n")
print(smallerNumbersThanCurrent([8,1,2,2,3]))