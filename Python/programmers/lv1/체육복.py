def solution(n, lost, reserve):
    lost_my_clothe = set(lost) & set(reserve)
    lost = set(lost) - lost_my_clothe
    reserve = set(reserve) - lost_my_clothe

    for lst in lost:
        if lst - 1 in reserve:
            reserve.remove(lst - 1)
        elif lst + 1 in reserve:
            reserve.remove(lst + 1)
        else:
            n -= 1

    return n
