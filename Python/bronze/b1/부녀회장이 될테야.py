re = int(input())

for i in range(re):
    k = int(input()) # floor
    n = int(input()) # room number
    saven = n
    savek = k
    a = []
    a.append([j for j in range(1,n+1)])

    for j in range(1,k+2):
        b = [1]
        for k in range(1,n):
            b.append( sum(a[j-1][0:k+1]))
        a.append(b)

    print(a[savek][saven-1])