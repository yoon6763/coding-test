def solution(n):
    answer = set()

    num = 2
    while n != 1:
        if n % num == 0:
            answer.add(num)
            n //= num
        else:
            num += 1

    return sorted(list(answer))