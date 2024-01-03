global student_num
global event_num
global max_score


def dfs(ability, selected_event_list, idx, score):
    global student_num
    global event_num
    global max_score

    if (student_num - idx) * 10000 + score <= max_score:
        return

    max_score = max(max_score, score)

    for i in range(idx, student_num):

        for j in range(event_num):
            if j in selected_event_list:
                continue

            selected_event_list.append(j)
            dfs(ability, selected_event_list, i + 1, score + ability[i][j])
            selected_event_list.pop()


def solution(ability):
    global student_num
    global event_num
    global max_score
    max_score = 0

    student_num = len(ability)
    event_num = len(ability[0])

    dfs(ability, [], 0, 0)

    return max_score
