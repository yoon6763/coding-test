re = int(input())
nums = list(map(int,input().split()))
count = 0
for i in nums:
    if i == 1:
        continue
    if i == 2 or i == 3:
        count = count + 1
        continue

    check = False
    for j in range(2,i):
        if i%j == 0:
            check = True
            break;

    if check == False:
        count = count+1

print(count)