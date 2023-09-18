while (True):
    num = list(map(int,input().split()))
    if sum(num) == 0:
        break;

    ma = max(num)
    temp = 0
    for i in range(0,3):
        if num[i] != ma:
            temp = temp + num[i] ** 2

    if temp == ma ** 2:
        print("right")
    else:
        print("wrong")