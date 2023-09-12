def solution(board, moves):
    answer = 0
    stack = []

    for i in moves:
        for k in range(len(board[0])):
            if board[k][i-1] != 0:
                stack.append(board[k][i-1])
                board[k][i-1] = 0

                if len(stack) >= 2 and (stack[-1] == stack[-2]):
                    stack.pop()
                    stack.pop()
                    answer = answer + 2
                break;
    return answer