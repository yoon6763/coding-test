def solution(myString):
    ans = ''
    for c in myString:
        if c < 'l':
            ans += 'l'
        else:
            ans += c
    return ans
