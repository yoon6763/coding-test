def solution(arr, queries):
    answer = []
    for query in queries:
        s, e, k = query
        temp = sorted([n for n in arr[s:e + 1] if n > k])
        if len(temp) == 0:
            answer.append(-1)
        else:
            answer.append(temp[0])

    return answer
