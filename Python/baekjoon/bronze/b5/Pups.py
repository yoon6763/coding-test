for _ in range(int(input())):
    n, pounds, money = map(float, input().split())
    print('$%.2f' % (n * pounds * money))
