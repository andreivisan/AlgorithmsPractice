def xor_operation(n, start):
    nums = []
    xor = 0;

    for i in range(n):
        nums.append(start + 2*i)
        xor ^= nums[i]

    return xor

print(xor_operation(5, 0))