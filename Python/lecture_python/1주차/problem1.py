n = int(input())

cnt = 0

for i in range(n):
    ls = list(input())

    used = [ls[0]]
    pre = ls[0]
    able = True

    for k in range(1, len(ls)):
        if pre != ls[k]:
            if ls[k] in used:
                able = False
                break

            pre = ls[k]
            used.append(ls[k])

    if able: cnt += 1

print(cnt)
