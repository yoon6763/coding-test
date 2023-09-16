def solution(a, d, included):
    ans = 0

    idx = 0
    while True:
        if idx >= len(included):
            break

        if included[idx]:
            ans += a + idx * d

        idx += 1

    return ans
