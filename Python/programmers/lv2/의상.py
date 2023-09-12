def solution(clothes):
    clo = {}

    for i in clothes:
        if i[1] in clo:
            clo[i[1]].append(i[0])
        else:
            clo[i[1]] = [i[0]]

    if len(clo) == 1:
        return len(list(clo.items())[0][1])
    else:
        cnt = 1
        for key,value in clo.items():
            cnt = cnt * (len(value) + 1)
        return cnt - 1