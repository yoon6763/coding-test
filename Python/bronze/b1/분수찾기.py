num = int(input())

if num == 1:
    print("1/1")
elif num == 2:
    print("1/2")
elif num == 3:
    print("2/1")
elif num == 4:
    print("3/1")
else:

    j = 0
    for j in range(num):
        if sum(range(0,j)) >= num:
            break;

    j = j - 1

    temp = num - sum(range(0,j))
    if j%2 == 0:
        print("{0}/{1}".format(temp,j-temp+1))
    else:
        print("{0}/{1}".format(j-temp+1,temp))