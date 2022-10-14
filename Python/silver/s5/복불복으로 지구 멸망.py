n = int(input()) - 1

case = 1
for i in range(n, 1, -2):
    case = case * i

print(case % (1000000000 + 7))