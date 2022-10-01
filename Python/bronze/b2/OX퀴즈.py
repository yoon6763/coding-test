num = int(input())

for i in range(num):
    st = list(input())
    score = 0
    count = 0

    for j in st:
        if j == 'O':
            count = count + 1
            score = score + count
        else:
            count = 0

    print(score)