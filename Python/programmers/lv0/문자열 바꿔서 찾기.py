def solution(myString, pat):
    myString = myString.replace('A', '1')
    myString = myString.replace('B', 'A')
    myString = myString.replace('1', 'B')
    if pat in myString:
        return 1
    else:
        return 0
