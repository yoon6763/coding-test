def solution(before, after):
    b = list(before)
    a = list(after)
    b.sort()
    a.sort()
    if b == a:
        return 1
    else:
        return 0
