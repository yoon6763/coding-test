def solution(myString, pat):
    lastIdx = myString.rfind(pat)
    return myString[:lastIdx + len(pat)]
