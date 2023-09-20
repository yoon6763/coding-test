package baekjoon.gold.g5.백도어

import java.util.PriorityQueue

data class Edge(val to: Int, val cost: Long)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val isEnableNode = readLine().split(" ").map { it != "1" }

    val graph = Array(n) { ArrayList<Edge>() }
    repeat(m) {
        val (s, e, t) = readLine().split(" ").map { it.toInt() }
        graph[s].add(Edge(e, t.toLong()))
        graph[e].add(Edge(s, t.toLong()))
    }

    val distance = dijkstra(n, isEnableNode, graph, 0)
    if (distance[n - 1] == Long.MAX_VALUE) println(-1) else println(distance[n - 1])
}

fun dijkstra(n: Int, isEnabledNode: List<Boolean>, graph: Array<ArrayList<Edge>>, start: Int): LongArray {
    val distance = LongArray(n) { Long.MAX_VALUE }
    distance[start] = 0

    val pq = PriorityQueue<Edge>(compareBy { it.cost })
    pq.offer(Edge(start, 0))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (distance[cur.to] < cur.cost) continue

        graph[cur.to].forEach { nextNode ->
            if (!isEnabledNode[nextNode.to] && nextNode.to != n - 1) return@forEach
            val nCost = distance[cur.to] + nextNode.cost

            if (nCost < distance[nextNode.to]) {
                distance[nextNode.to] = nCost
                pq.offer(Edge(nextNode.to, nCost))
            }
        }
    }

    return distance
}
