def solution(intStrs, k, s, l):
    answer = []

    for n in intStrs:
        temp = int(n[s:s + l])
        if temp > k:
            answer.append(temp)

    return answer
