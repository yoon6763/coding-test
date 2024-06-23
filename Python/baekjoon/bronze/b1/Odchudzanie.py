input()
maxValue = 0
minValue = 1000000
ans = 0
for i in map(int, input().split()):
    minValue = min(minValue, i)
    if maxValue < i:
        maxValue = i
        minValue = i
    ans = max(maxValue - minValue, ans)
print(ans)