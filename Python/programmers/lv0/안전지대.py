def solution(board):
    n = len(board)
    map = [[1] * n for _ in range(n)]

    dx = [0, 0, 1, -1, 1, 1, -1, -1]
    dy = [1, -1, 0, 0, 1, -1, 1, -1]

    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                map[i][j] = 0

                for k in range(8):
                    nx = i + dx[k]
                    ny = j + dy[k]

                    if nx < 0 or nx >= n or ny < 0 or ny >= n:
                        continue

                    map[nx][ny] = 0

    return sum([sum(i) for i in map])
