def solution(arr):
    answer = []
    for i in range(0, len(arr)):
        for j in range(0, arr[i]):
            answer.append(arr[i])
    return answer
