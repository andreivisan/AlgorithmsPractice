def rotate(nums, k):
    n = len(nums)
    a = [0] * n
    for i in range(n):
        a[(i + k) % n] = nums[i]
        
    nums[:] = a
    print(nums)

rotate([1, 2, 3, 4, 5, 6, 7], 3)