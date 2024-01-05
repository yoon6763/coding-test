from collections import deque


def solution(n, edge):
    connect = [[] for _ in range(n + 1)]
    for (v1, v2) in edge:
        connect[v1].append(v2)
        connect[v2].append(v1)

    visited = [0] * (n + 1)
    queue = deque()
    queue.append((1, 0))
    visited[1] = 1

    while queue:
        (cur, depth) = queue.popleft()
        for next in connect[cur]:
            if visited[next] == 0:
                visited[next] = depth + 1
                queue.append((next, depth + 1))

    return visited.count(max(visited))
