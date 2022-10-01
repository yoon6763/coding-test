import math

a,b,v = map(int,(input().split()))

v = v - a

print(math.ceil(v / (a - b)) + 1)
