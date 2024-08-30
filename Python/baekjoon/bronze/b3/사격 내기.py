a, b = map(int, input().split())
print(int(bin(a ^ b)[2:], 2))
