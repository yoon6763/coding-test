def solution(s):
    answer = 0
    pre = 0
    for n in s.split(' '):
        if n == 'Z':
            answer -= pre
        else:
            answer += int(n)
            pre = int(n)

    return answer