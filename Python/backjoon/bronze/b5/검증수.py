a = list(map(int,input().split()))

a = [ i**2 for i in a ]

print(sum(a)%10)