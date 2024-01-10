from collections import deque


def solution(n, m, hole):
    queue = deque()

    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    visited = [[[0] * m for _ in range(n)] for _ in range(2)]
    visited[0][0][0] = 1
    queue.append((0, 0, 0))

    map = [[0] * m for _ in range(n)]
    for h in hole:
        map[h[0] - 1][h[1] - 1] = 1

    while queue:
        (x, y, use_jump) = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            nnx = nx + dx[i]
            nny = ny + dy[i]

            if 0 <= nx < n and 0 <= ny < m and visited[use_jump][nx][ny] == 0 and map[nx][ny] == 0:
                visited[use_jump][nx][ny] = visited[use_jump][x][y] + 1
                queue.append((nx, ny, use_jump))
                if nx == n - 1 and ny == m - 1:
                    return visited[use_jump][nx][ny] - 1

            if use_jump == 0 and 0 <= nnx < n and 0 <= nny < m and visited[use_jump][nnx][nny] == 0 and map[nnx][nny] == 0:
                visited[1][nnx][nny] = visited[use_jump][x][y] + 1
                queue.append((nnx, nny, 1))
                if nnx == n - 1 and nny == m - 1:
                    return visited[1][nnx][nny] - 1

    return -1
