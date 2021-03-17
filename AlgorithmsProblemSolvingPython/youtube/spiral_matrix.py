def spiral_order(matrix):
    result = []
    spiral_helper(matrix, 0, len(matrix) - 1, 0, len(matrix[0]) - 1, result)
    return result


def spiral_helper(matrix, start_row, end_row, start_column, end_column, result):
    if start_row > end_row or start_column > end_column:
        return

    for col in range(start_column, end_column + 1):
        result.append(matrix[start_row][col])

    for row in range(start_row + 1, end_row + 1):
        result.append(matrix[row][end_column])

    for col in reversed(range(start_column, end_column)):
        # Handle the edge case when there is a single row
        # in the middle of the matrix. In this case, we don't
        # want to double-count the values in this row, which
        # we've already counted in the first for loop above.
        if start_row == end_row:
            break
        result.append(matrix[end_row][col])

    for row in reversed(range(start_row + 1, end_row)):
        # Handle the edge case where there is a single column
        # in the middle of the matrix. In this case, we don't
        # want to double-count the values in this column, which
        # we've already counted in the second for loop above.
        if start_column == end_column:
            break
        result.append(matrix[row][start_column])

    spiral_helper(matrix, start_row + 1, end_row - 1,
                  start_column + 1, end_column - 1, result)

                  result = []
        spiral_helper(matrix, 0, len(matrix) - 1, 0,       len(matrix[0]) - 1, result)
        return result


if __name__ == "__main__":
    matrix = [
        [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]
    ]

    answer = spiral_order(matrix)

    for index in range(len(answer)):
        print(answer[index])
