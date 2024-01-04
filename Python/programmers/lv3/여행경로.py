def solution(tickets):
    complete_paths = []
    dfs(tickets, "ICN", ["ICN"], 0, complete_paths, [False] * len(tickets))
    complete_paths.sort()
    return complete_paths[0]


def dfs(tickets, cur, path, depth, complete_paths, visited):
    if depth == len(tickets):
        complete_paths.append(path)
        return

    for index, ticket in enumerate(tickets):
        (start, end) = ticket
        if visited[index] == False and cur == start:
            visited[index] = True
            dfs(tickets, end, path + [end], depth + 1, complete_paths, visited)
            visited[index] = False
