def solution(arr):
    cnt = 0

    while True:
        cnt += 1
        flag = True

        for i in range(len(arr)):
            if arr[i] >= 50 and arr[i] % 2 == 0:
                if arr[i] != arr[i] // 2:
                    flag = False
                arr[i] //= 2
            if arr[i] < 50 and arr[i] % 2 == 1:
                if arr[i] != arr[i] * 2 + 1:
                    flag = False
                arr[i] = arr[i] * 2 + 1

        if flag:
            break

    return cnt - 1