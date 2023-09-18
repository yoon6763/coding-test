line = input()
alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

line = [alphabet.index(ch) for ch in line]

result = 0
pre = 0

for i in line:
    cnt = 0
    right = pre
    left = pre

    while right != i and left != i:
        right += 1
        left -= 1
        cnt += 1
        if right >= 26:
            right = 0
        if left < 0:
            left = 25

    result += cnt
    pre = i

print(result)
