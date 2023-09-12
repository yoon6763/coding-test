def solution(arr):
    num = max(arr)
    while (True):
        cnt = 0
        for i in range(len(arr)):
            if num % arr[i] == 0:
                cnt = cnt + 1
        if cnt == len(arr):
            return num
        num = num + 1