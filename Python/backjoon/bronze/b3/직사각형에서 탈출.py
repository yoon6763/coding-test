a = list(map(int, input().split()))
result = min(a[0],a[1],a[2]-a[0],a[3]-a[1])
print(result)