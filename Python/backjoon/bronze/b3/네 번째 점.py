point = []

for i in range(3):
    x = list(map(int,input().split()))
    point.append(x)

x = []
y = []
for i in range(3):
    x.append(point[i][0])
    y.append(point[i][1])

px = 0
py = 0

if x[0] == x[1]:
    px = x[2]
elif x[0] == x[2]:
    px = x[1]
else:
    px = x[0]

if y[0] == y[1]:
    py = y[2]
elif y[0] == y[2]:
    py = y[1]
else:
    py = y[0]

print(px,py)