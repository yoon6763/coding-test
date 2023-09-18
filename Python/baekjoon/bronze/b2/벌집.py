num = 0
plus = 1

get = int(input())

i = 0

for i in range(get):
    num = num + plus
    plus = plus + 1

    max = 6 * num + 1

    if get <= max:
        break;

if get == 1:
    print(1)
elif get <= 7:
    print(2)
else:
    print(i+2)