def solution(numbers):
    ans = -10000 * 10000
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            ans = max(ans, numbers[i] * numbers[j])
    return ans
