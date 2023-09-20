def solution(score):
    answer = []
    for i in range(len(score)):
        answer.append([i + 1, sum(score[i]), -1])

    answer.sort(key=lambda x: x[1], reverse=True)

    for i in range(len(score)):
        if i > 0 and answer[i][1] == answer[i - 1][1]:
            answer[i][2] = answer[i - 1][2]
        else:
            answer[i][2] = i + 1

    answer.sort(key=lambda x: x[0])
    return [i[2] for i in answer]
