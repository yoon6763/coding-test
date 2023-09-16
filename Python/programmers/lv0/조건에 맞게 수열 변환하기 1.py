def solution(arr):
    answer = []
    for i in range(len(arr)):
        if arr[i] >= 50 and arr[i] % 2 == 0:
            answer.append(arr[i] / 2)
        elif arr[i] < 50 and arr[i] % 2 == 1:
            answer.append(arr[i] * 2)
        else:
            answer.append(arr[i])
    return answer
