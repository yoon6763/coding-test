import math

stlist = list(input())

result = 0
for ch in stlist:
    if ch == 'Z':
        index = 9
    elif ch == 'S':
        index = 7
    elif ord(ch) > ord('S'):
        index = math.ceil((ord(ch) - ord('A')) / 3) + 1
    else:
        index = math.ceil((ord(ch) - ord('A') + 1) / 3) + 1

    result = result + index + 1
print(result)