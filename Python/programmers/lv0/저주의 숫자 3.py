def solution(n):
    answer = 0
    cnt = 0

    while n > cnt:
        cnt += 1
        answer += 1

        while cnt % 3 == 0 or '3' in str(cnt):
            answer += 1

    return answer