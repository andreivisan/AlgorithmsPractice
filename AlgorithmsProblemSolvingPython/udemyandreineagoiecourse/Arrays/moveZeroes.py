#Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

#Example:
#Input: [0,1,0,3,12]
#Output: [1,3,12,0,0]

def moveZeroes(nums):
    
    numOps = i = 0;
    while numOps < len(nums) and i < len(nums):
        if nums[i] == 0:
            nums.pop(i)
            nums.append(0)
        else:
            i += 1
        
        numOps += 1

    print(nums)


moveZeroes([0, 0, 1])

