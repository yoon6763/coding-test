def solution(n):
    answer = []
    while n != 1:
        answer.append(n)
        if n % 2 == 0:
            n //= 2
        else:
            n = n * 3 + 1
    answer.append(1)
    return answer