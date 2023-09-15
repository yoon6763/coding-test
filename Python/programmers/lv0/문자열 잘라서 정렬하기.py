def solution(myString):
    return sorted([x for x in myString.split('x') if x != ''])
