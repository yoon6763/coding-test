n = int(input())

if n <= 4:
    arr = [4, 6, 10, 16]
    print(arr[n-1])
    exit(0)

arr = [1, 1]

for i in range(2, n):
    arr.append(arr[i - 1] + arr[i - 2])

print(arr[n - 1] * 3 + arr[n - 2] * 2 + arr[n - 3] * 2 + arr[n - 4])
