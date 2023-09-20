def solution(quiz):
    answer = []
    for q in quiz:
        x, oper, y, equal, z = q.split(' ')
        x, y, z = int(x), int(y), int(z)

        if oper == '+' and x + y == z:
            answer.append("O")
        elif oper == '-' and x - y == z:
            answer.append("O")
        else:
            answer.append("X")
    return answer
