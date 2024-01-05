import heapq


class Edge:
    def __init__(self, to, cost):
        self.to = to
        self.cost = cost

    def __lt__(self, other):
        return self.cost < other.cost


def solution(N, road, K):
    graph = [[] for _ in range(N + 1)]
    for (v1, v2, cost) in road:
        graph[v1].append(Edge(v2, cost))
        graph[v2].append(Edge(v1, cost))

    distance = [987654321] * (N + 1)
    distance[1] = 0

    priority_queue = []
    heapq.heappush(priority_queue, Edge(1, 0))

    while priority_queue:
        cur = heapq.heappop(priority_queue)
        for next in graph[cur.to]:
            new_cost = distance[cur.to] + next.cost
            if new_cost < distance[next.to]:
                distance[next.to] = new_cost
                heapq.heappush(priority_queue, Edge(next.to, new_cost))

    return len([d for d in distance if d <= K])
