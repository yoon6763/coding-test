def solution(numbers, k):
    cnt = 1
    idx = 1

    while cnt < k:
        idx += 2
        cnt += 1
        if idx >= len(numbers):
            idx %= len(numbers)

    return numbers[idx - 1]
