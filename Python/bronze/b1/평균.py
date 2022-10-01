num = int(input())
n = list(map(int, input().split()))
max = max(n)

for i in range(num):
    n[i] = n[i] / max * 100

print(sum(n)/num)