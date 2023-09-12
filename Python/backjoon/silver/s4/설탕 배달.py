we = int(input())

kg1 = 0 #5kg
kg2 = 0 #3kg

while(True):
    if kg1 * 5 > we:
        kg1 = kg1 - 1
        break;
    if kg1 * 5 == we:
        break;
    kg1 = kg1 + 1


while(kg1>=0):
    if (kg1 * 5 + kg2 * 3) == we:
        break;
    kg2 = kg2 + 1

    if (kg1 * 5 + kg2 * 3) > we:
        kg2 = 0
        kg1 = kg1 - 1


if kg1 == -1:
    print(-1)
else:
    print(kg1 + kg2)