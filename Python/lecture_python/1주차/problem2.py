n = int(input())

if n not in range(2, 10):
    print("2 ~ 9 사이 숫자를 입력해주세요")
else:
    for i in range(1, 10):
        print("{0} * {1} = {2}".format(n, i, n * i))
