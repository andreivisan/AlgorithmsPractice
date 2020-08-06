def majority_element(nums):
    majority = 0
    countMap = {}

    for i in range(len(nums)):
        if countMap.get(nums[i]):
            countMap[nums[i]] += 1
        else: 
            countMap[nums[i]] = 1

    temp = 0
    for key in countMap.keys():
        if countMap[key] > temp:
            temp = countMap[key]
            majority = key

    return majority

print(majority_element([3,1,3]))