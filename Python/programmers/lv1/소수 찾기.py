def solution(n):
    cnt = 0
    a = [False, False] + [True] * (n - 1)

    for i in range(2, n + 1):
        if a[i]:
            cnt = cnt+1
            for j in range(2 * i, n + 1, i):
                a[j] = False

    return cnt