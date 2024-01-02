def solution(n):
    lst = list(str(n))
    lst.reverse()
    return list(map(int, lst))