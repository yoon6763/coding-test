def solution(myString, pat):
    if pat.lower() in myString.lower():
        return 1
    else:
        return 0