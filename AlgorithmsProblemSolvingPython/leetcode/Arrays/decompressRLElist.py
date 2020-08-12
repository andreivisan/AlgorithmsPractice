def decompress_rle_list(nums):
    result = []

    for i in range(len(nums) - 1):
        if i % 2 == 0:
            for j in range(nums[i]):
                result.append(nums[i + 1])

    return result

print(decompress_rle_list([1, 2, 3, 4]))