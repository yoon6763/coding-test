def solution(skill, skill_trees):
    cnt = 0
    tree = list(skill)
    for i in skill_trees:
        temp = [k for k in list(i) if k in skill]
        if temp == tree[0:len(temp)]:
            cnt = cnt + 1
    print(cnt)
    return cnt