n = int(input())

for i in range(n):
    num = list(map(int, input().split()))

    avg = sum(num[1:])/num[0]
    count = 0

    for j in range(num[0]):
        if avg < num[j+1]:
            count = count + 1

    print('{0:.3f}%'.format( round( (count / num[0]) * 100,3) ) )