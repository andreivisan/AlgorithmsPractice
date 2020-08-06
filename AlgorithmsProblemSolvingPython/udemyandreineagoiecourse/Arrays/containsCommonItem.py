array1 = ["a", "b", "c", "x"]
array2 = ["x", "y", "z"]

map = {}
result = []
def containsCommonItem(arr1, arr2):
    for i in range(len(arr1)):
        if not arr1[i] in map.keys():
            item = arr1[i]
            map[item] = True

    for j in range(len(arr2)):
        if arr2[j] in map.keys():
            result.append(arr2[j])

    return result

def containsCommonItemSet(arr1, arr2):
    letterSet = set(arr1)
    
    for value in arr2:
        letterSet.add(value)

    if len(letterSet) < len(arr1) + len(arr2):
        return "True"
    
    return "False"

print(containsCommonItem(array1, array2))
print(containsCommonItemSet(array1, array2))