def solution(num, k):
    ans = str(num).find(str(k))
    if ans == -1:
        return -1
    return ans + 1