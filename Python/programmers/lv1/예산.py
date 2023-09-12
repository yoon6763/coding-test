def solution(d, budget):
    d.sort()
    cnt = 0
    s = 0
    while(True):
        s = s + d[cnt]
        cnt = cnt + 1
        if s > budget:
            return cnt-1
        elif s == budget:
            return cnt
        if cnt == len(d):
            return len(d)