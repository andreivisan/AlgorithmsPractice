def flip_and_invert_image(A):
    for i in range(len(A)):
        reversed_row = A[i][::-1]
        for j in range(len(reversed_row)):
            reversed_row[j] = reversed_row[j] ^ 1
        A[i] = reversed_row

    return A

print(flip_and_invert_image([[1,1,0],[1,0,1],[0,0,0]]))