def solution(rsp):
    ans = ""
    for c in rsp:
        if c == '2':
            ans += '0'
        elif c == '0':
            ans += '5'
        else:
            ans += '2'
    return ans
