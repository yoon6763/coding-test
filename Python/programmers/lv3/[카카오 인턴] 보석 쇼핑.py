def solution(gems):
    n = len(gems)

    gems_set = set(gems)
    gems_kind_count = len(gems_set)
    gems_dict = {g: 0 for g in gems_set}

    gems_dict[gems[0]] = 1

    left = 0
    right = 1
    ans_length = 987654321
    ans = [0, 1]
    my_gems_kind_count = 1

    while left <= right <= n:
        if my_gems_kind_count == gems_kind_count:
            if ans_length > right - left:
                ans_length = right - left
                ans = [left, right - 1]

            gems_dict[gems[left]] = gems_dict[gems[left]] - 1
            if gems_dict[gems[left]] == 0:
                my_gems_kind_count -= 1
            left += 1

        elif my_gems_kind_count < gems_kind_count:
            if right == n:
                break
            gems_dict[gems[right]] = gems_dict[gems[right]] + 1
            if gems_dict[gems[right]] == 1:
                my_gems_kind_count += 1

            right += 1

        elif my_gems_kind_count > gems_kind_count:
            gems_dict[gems[left]] = gems_dict[gems[left]] - 1
            if gems_dict[gems[left]] == 0:
                my_gems_kind_count -= 1
            left += 1

    return [ans[0] + 1, ans[1] + 1]
