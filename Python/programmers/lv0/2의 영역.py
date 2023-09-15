def solution(arr):
    start = -1
    end = -1
    for i in range(len(arr)):
        if arr[i] == 2:
            if start == -1:
                start = i
            end = i
    if start == -1:
        return [-1]
    else:
        return arr[start:end+1]