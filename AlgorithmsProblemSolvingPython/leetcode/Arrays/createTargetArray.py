def create_target_array(nums, index):
    result = []

    for i in range(len(index)):
        result.insert(index[i], nums[i])

    return result

print(create_target_array([0,1,2,3,4], [0,1,2,2,1]))