n = int(input())

fact = [1, 1]
for i in range(2, 21):
    fact.append(fact[i - 1] * i)

sum = 0

for i in range(20, -1, -1):
    if sum + fact[i] < n:
        sum += fact[i]
    elif sum + fact[i] == n:
        print("YES")
        exit(0)

print("NO")
