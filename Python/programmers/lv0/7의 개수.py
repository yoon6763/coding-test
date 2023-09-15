def solution(array):
    answer = 0
    for arr in array:
        for i in str(arr):
            if i == '7':
                answer += 1

    return answer
