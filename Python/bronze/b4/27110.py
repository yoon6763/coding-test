n = int(input())
n1, n2, n3 = map(int,input().split(" "))

sum = 0
if n1 > n:
    sum += n
else:
    sum += n1

if n2 > n:
    sum += n
else:
    sum += n2

if n3 > n:
    sum +=n
else: sum += n3

print(sum)