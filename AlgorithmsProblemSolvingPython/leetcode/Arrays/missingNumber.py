def missing_number(nums):
    n = len(nums)
    gaussSum = (n * (n + 1))/2
    sum = 0

    for index, value in enumerate(nums):
        sum += value

    return gaussSum - sum

print(missing_number([9,6,4,2,3,5,7,0,1]))