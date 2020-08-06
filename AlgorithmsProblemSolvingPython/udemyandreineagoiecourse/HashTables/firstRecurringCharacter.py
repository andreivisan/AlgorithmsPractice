def firstRecurringCharacter(nums):
    buffer = {}

    for index, value in enumerate(nums):
        if value in buffer:
            return value
        else:
            buffer[value] = 0

    return 0
 
print(firstRecurringCharacter([2,5,5,2,3,5,1,2,4]))