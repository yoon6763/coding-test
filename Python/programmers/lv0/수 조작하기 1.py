def solution(n, control):
    res = n
    for c in control:
        if c == 'w':
            res += 1
        elif c == 's':
            res -= 1
        elif c == 'd':
            res += 10
        elif c == 'a':
            res -= 10
    return res