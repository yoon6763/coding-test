def solution(array):
    answer = [0] * 1001
    for n in array:
        answer[n] += 1
    if answer.count(max(answer)) > 1:
        return -1
    return answer.index(max(answer))