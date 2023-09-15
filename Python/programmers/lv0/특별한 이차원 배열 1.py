def solution(n):
    ans = []
    for i in range(1, n+1):
        temp = []
        for j in range(1, n+1):
            if i == j:
                temp.append(1)
            else:
                temp.append(0)
        ans.append(temp)
    return ans
