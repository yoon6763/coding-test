def solution(strArr):
    for i in range(len(strArr)):
        if i % 2 == 1:
            strArr[i] = strArr[i].upper()
        else:
            strArr[i] = strArr[i].lower()
    return strArr
