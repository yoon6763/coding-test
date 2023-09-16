def solution(arr, k):
    answer = [-1] * k
    idx = 0
    for n in arr:
        if idx == k:
            break
        if n not in answer:
            answer[idx] = n
            idx += 1
    return answer
