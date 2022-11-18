n, m = map(int, input().split(" "))

str = []

for i in range(n):
    str.append(input())

for i in range(n - 1):
    str1 = str[i]
    str2 = str[i + 1]

    isAble = False

    for j in range(1, m + 1):
        if str1[m - j:] == str2[:j]:
            isAble = True
            break
        if str1[:j] == str2[m - j:]:
            isAble = True
            break

    if not isAble:
        print(0)
        exit(0)

print(1)
