def solution(dartResult):
    dartResult = dartResult.replace('10','x')
    lst = list(dartResult)

    arr = list()
    temparr = ''
    for i in lst:
        if i in ['0','1','2','3','4','5','6','7','8','9','x']:
            arr.append(temparr)
            temparr = ''
            temparr = temparr + i
        else:
            temparr = temparr + i
    arr.append(temparr)
    arr.pop(0)

    num = [ 0 for i in range(0,len(arr))]

    for i in range(len(arr)):
        for k in arr[i]:
            if k in ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9','x']:
                if k == 'x':
                    num[i] = 10
                else:
                    num[i] = int(k)
            if k == 'D':
                num[i] = num[i] ** 2
            elif k == 'T':
                num[i] = num[i] ** 3
            elif k == '#':
                num[i] = -num[i]
            elif k == '*':
                if i != 0:
                    num[i-1] = num[i-1] * 2
                num[i] = num[i] * 2

    return sum(num)