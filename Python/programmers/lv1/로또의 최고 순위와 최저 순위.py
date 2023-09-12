def solution(lottos, win_nums):
    match = 0
    max = 0
    for i in lottos:
        if i in win_nums:
            match = match + 1
        elif i == 0:
            max = max + 1

    a1 = 0
    a2 = 0
    if match == 6:
        a1 = 1
    elif match == 5:
        a1 = 2
    elif match == 4:
        a1 = 3
    elif match == 3:
        a1 = 4
    elif match == 2:
        a1 = 5
    else:
        a1 = 6

    if match + max == 6:
        a2 = 1
    elif match + max == 5:
        a2 = 2
    elif match + max == 4:
        a2 = 3
    elif match + max == 3:
        a2 = 4
    elif match + max == 2:
        a2 = 5
    else:
        a2 = 6

    return [a2, a1]