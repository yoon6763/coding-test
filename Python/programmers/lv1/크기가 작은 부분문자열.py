def solution(t, p):
    p_len = len(p)
    sub_str = [t[i:i + p_len] for i in range(0, len(t) - p_len + 1)]
    return sum(1 for s in sub_str if int(s) <= int(p))