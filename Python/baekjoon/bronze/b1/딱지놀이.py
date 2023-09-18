t = int(input())

for t in range(t):
    aList = [0, 0, 0, 0, 0]
    bList = [0, 0, 0, 0, 0]

    for i in list(map(int, input().split(" ")))[1:]:
        aList[i] += 1
    for i in list(map(int, input().split(" ")))[1:]:
        bList[i] += 1


    for i in range(4, -1, -1):
        if i == 0:
            print("D")
            break
        if aList[i] > bList[i]:
            print("A")
            break
        elif aList[i] < bList[i]:
            print("B")
            break
