def solution(chicken):
    answer = 0

    while chicken >= 10:
        chicken -= 9
        answer += 1

    return answer