def solution(n, lost, reserve):
    arr = [i for i in range(1, n + 1) if i not in lost]

    tempre = []
    for i in reserve:
        # 예비를 챙겨왔는데 도난
        if i not in arr:
            tempre.append(i)
            arr.append(i)
    reserve = [i for i in reserve if i not in tempre]
    lost = [i for i in lost if i not in tempre]

    arr.sort()

    for i in lost:
        if i - 1 in reserve:
            arr.append(i)
            reserve.remove(i-1)
        elif i + 1 in reserve:
            arr.append(i)
            reserve.remove(i+1)

    return len(arr)