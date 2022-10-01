a = []

for i in range(10):
    num = int(input()) % 42
    if num not in a:
        a.append(num)

print(len(a))