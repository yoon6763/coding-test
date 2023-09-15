def solution(s):
    cnt = [0] * 26
    for i in s:
        cnt[ord(i) - 97] += 1
    ans = ''
    for i in range(len(cnt)):
        if cnt[i] == 1:
            ans += chr(i + 97)
    return ans