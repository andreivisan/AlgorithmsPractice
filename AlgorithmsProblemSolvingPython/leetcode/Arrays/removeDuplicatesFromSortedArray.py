def removeDuplicates(nums):
    if len(nums) == 0:
        return 0

    i = 0
    for j in range(len(nums)):
        if nums[j] != nums[i]:
            i = i + 1
            nums[i] = nums[j]

    return i + 1

input1 = [1, 1, 2]
input2 = [0,0,1,1,1,2,2,3,3,4]
input3 = []

print(removeDuplicates(input1))
print("\n")
print(removeDuplicates(input2))
print("\n")
print(removeDuplicates(input3))
print("\n") 