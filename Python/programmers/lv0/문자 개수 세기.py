def solution(my_string):
    ans = [0] * 52
    for char in my_string:
        if char.isupper():
            ans[ord(char) - ord('A')] += 1
        else:
            ans[ord(char) - ord('a') + 26] += 1
    return ans
