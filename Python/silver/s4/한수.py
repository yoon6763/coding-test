def sequence(n):
    if n <= 9:
        return True

    num = []
    for i in map(int, str(n)):
        num.append(i)

    dif = num[0]-num[1]

    for i in range(1,len(num)-1):
        if (num[i] - num[i+1]) != dif:
            return False

    return True


cnt = 0
num = int(input())

for i in range(1,num+1):
    if sequence(i):
        cnt = cnt + 1

print(cnt)