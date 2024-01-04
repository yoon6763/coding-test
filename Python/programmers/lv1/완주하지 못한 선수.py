def solution(participant, completion):
    dt = {}
    for p in participant:
        dt[p] = dt.get(p, 0)
    for c in completion:
        dt[c] = dt[c] - 1
    for d in dt.keys():
        if dt[d] == 1:
            return dt[d]
