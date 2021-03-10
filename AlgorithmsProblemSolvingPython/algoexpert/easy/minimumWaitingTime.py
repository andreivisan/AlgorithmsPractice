def minimumWaitingTime(queries):
    queries.sort()

    sum = 0

    for index, time in enumerate(queries):
        queries_left = len(queries) - (index + 1)
        sum += time * queries_left

    return sum


if __name__ == "__main__":
    queries = [3, 2, 1, 2, 6]

    print(minimumWaitingTime(queries))
