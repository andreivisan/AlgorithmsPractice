#Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

#Example:
#Input: [-2,1,-3,4,-1,2,1,-5,4],
#Output: 6
#Explanation: [4,-1,2,1] has the largest sum = 6.

def maxSubArray(nums):
    maxCurrent = nums[0]
    maxOverall = nums[0]

    for i in range(1, len(nums)):
        maxCurrent = max(maxCurrent + nums[i], nums[i])
        if(maxCurrent > maxOverall):
            maxOverall = maxCurrent

    return maxOverall

print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))