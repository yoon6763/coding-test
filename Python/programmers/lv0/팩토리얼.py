def solution(n):
    answer = 0

    factorial = 1
    for i in range(1, n + 1):
        factorial *= i

        if factorial > n:
            break

        answer = i

    return answer
