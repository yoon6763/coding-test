def solution(n):
    ans = 0
    pre = n
    for a in range(1, n + 1):
        for b in range(1, pre + 1):
            if a * b == n:
                ans += 1
                pre = b
                break

    return ans
