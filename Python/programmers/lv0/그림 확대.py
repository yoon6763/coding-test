def solution(picture, k):
    answer = [i for i in range(1, len(picture) * k)]

    for i in range(0, len(picture), k):
        for j in range(0, len(picture[0]), k):
            for x in range(k):
                for y in range(k):
                    answer[i * k + j + x * k + y] = picture[i + x][j + y]

    return answer
