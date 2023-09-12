def solution(arr):
    n = len(arr)
    cnt0 = 0
    cnt1 = 0
    while n > 1:
        for i in range(int(len(arr) / n)):
            for j in range(int(len(arr) / n)):
                if arr[i*n][j*n] == 0: values = 0
                elif arr[i*n][j*n] == 1 : values = 1

                check = False
                for k in range(n):
                    for l in range(n):
                        if values != arr[i * n + k][j * n + l]:
                            check = True
                            break;
                if check == False:
                    if values == 0:
                        cnt0 = cnt0 + 1
                    else:
                        cnt1 = cnt1 + 1
                    for k in range(n):
                        for l in range(n):
                            arr[i * n + k][j * n + l] = values + 2
        n = n / 2
        if n == 0.5: n = 0
        n = int(n)

    for i in range(len(arr)):
        cnt0 = cnt0 + arr[i].count(0)
        cnt1 = cnt1 + arr[i].count(1)

    return [cnt0, cnt1]