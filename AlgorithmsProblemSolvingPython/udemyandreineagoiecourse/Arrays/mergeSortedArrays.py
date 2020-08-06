def mergeSortedArrays(array1, array2):
    array1.extend(array2)
    return sorted(array1)

print(mergeSortedArrays([0,3,4,31], [4, 6, 30]))    