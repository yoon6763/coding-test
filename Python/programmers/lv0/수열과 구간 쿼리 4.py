def solution(arr, queries):
    for query in queries:
        (start, end, k) = query
        for i in range(start, end + 1):
            if i % k == 0:
                arr[i] += 1
    return arr
