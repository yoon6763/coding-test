def solution(rank, attendance):
    arr = [[i, rank[i]] for i in range(len(rank)) if attendance[i]]
    print(arr)
    arr.sort(key=lambda x: x[1])
    print(arr)
    return arr[0][0] * 10000 + arr[1][0] * 100 + arr[2][0]
