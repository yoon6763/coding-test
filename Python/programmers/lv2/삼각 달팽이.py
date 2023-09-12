def solution(n):
    arr = [[0] * n for i in range(n)]

    maxnum = 0
    for i in range(1, n + 1):
        maxnum = maxnum + i

    x = y = 0
    num = 1
    switch = 0

    while (num <= maxnum):
        arr[x][y] = num
        if switch == 0:
            x = x + 1
            if x > n - 1 or arr[x][y] != 0:
                switch = 1
                x = x - 1
                y = y + 1
        elif switch == 1:
            y = y + 1
            if y > n - 1 or arr[x][y] != 0:
                switch = 2
                y = y - 1
                num = num - 1
        elif switch == 2:
            x = x - 1
            y = y - 1
            if x == 0 or arr[x][y] != 0:
                switch = 0
                x = x + 1
                y = y + 1
                num = num - 1
        num = num + 1

    arr2 = []
    for i in range(len(arr)):
        for j in range(len(arr)):
            if arr[i][j] != 0:
                arr2.append(arr[i][j])
    return arr2