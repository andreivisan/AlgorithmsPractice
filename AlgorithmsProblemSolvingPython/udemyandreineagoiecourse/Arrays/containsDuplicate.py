#Given an array of integers, find if the array contains any duplicates.
#Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
#Input: [1,2,3,1]
#Output: true
def containsDuplicate(nums):
    return len(nums) > len(set(nums))

print(containsDuplicate([1,2,3,1]))
print(containsDuplicate([1,2,3,4]))