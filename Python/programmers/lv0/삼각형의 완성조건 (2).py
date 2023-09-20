def solution(sides):
    sides.sort()
    ans = 0
    for i in range(sides[1] - sides[0] + 1, sides[1] + 1):
        ans += 1
    for i in range(sides[1] + 1, sides[0] + sides[1]):
        ans += 1
    return ans
