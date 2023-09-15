def solution(arr):
    target_len = 1
    while target_len < len(arr):
        target_len *= 2
    for i in range(target_len - len(arr)):
        arr.append(0)
    return arr