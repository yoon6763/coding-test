import math


def solution(n, words):
    for i in range(0, len(words)):
        if words[i] in words[0:i]:
            a = (i + 1) % n
            if a == 0: a = n
            b = math.ceil((i + 1) / n)

            return [a, b]

        elif i != 0 and words[i - 1][-1] != words[i][0]:
            a = (i + 1) % n
            if a == 0: a = n
            b = math.ceil((i + 1) / n)

            return [a, b]

    return [0, 0]