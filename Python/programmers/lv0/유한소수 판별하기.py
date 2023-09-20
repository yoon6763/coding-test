def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def solution(a, b):
    b = b / gcd(a, b)
    while b % 2 == 0:
        b //= 2
    while b % 5 == 0:
        b //= 5
    return 1 if b == 1 else 2
