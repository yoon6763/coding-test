def solution(n, wires):
    global connect

    connect = [[False] * (n + 1) for _ in range(n + 1)]
    for (v1, v2) in wires:
        connect[v1][v2] = True
        connect[v2][v1] = True

    answer = 987654321

    for (v1, v2) in wires:
        global size
        size = 0

        connect[v1][v2] = False
        connect[v2][v1] = False

        dfs(n, 1, [False] * (n + 1))
        connect[v1][v2] = True
        connect[v2][v1] = True

        answer = min(answer, abs(size - (n - size)))

    return answer


def dfs(n, cur, visited):
    global connect
    global size
    size += 1
    visited[cur] = True

    for next_node in range(1, n + 1):
        if connect[cur][next_node] == True and visited[next_node] == False:
            dfs(n, next_node, visited)
