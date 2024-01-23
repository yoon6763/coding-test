package programmers.lv3.`등산코스 정하기`

import java.util.PriorityQueue

data class Edge(val to: Int, val cost: Int)

fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {
    val graph = Array(n + 1) { ArrayList<Edge>() }
    for (path in paths) {
        if (path[0] in gates || path[1] in summits) {
            graph[path[0]].add(Edge(path[1], path[2]))
            continue
        }

        if (path[0] in summits || path[1] in gates) {
            graph[path[1]].add(Edge(path[0], path[2]))
            continue
        }

        graph[path[0]].add(Edge(path[1], path[2]))
        graph[path[1]].add(Edge(path[0], path[2]))
    }

    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Edge>(compareBy { it.cost })
    for (gate in gates) {
        dist[gate] = 0
        pq.add(Edge(gate, 0))
    }

    while (pq.isNotEmpty()) {
        val (to, cost) = pq.poll()

        if (dist[to] < cost) continue

        for (next in graph[to]) {
            val newWeight = maxOf(dist[to], next.cost)
            if (dist[next.to] > newWeight) {
                dist[next.to] = newWeight
                pq.add(Edge(next.to, newWeight))
            }
        }
    }
    summits.sort()

    var answerSummit = Int.MAX_VALUE
    var answerCost = Int.MAX_VALUE

    for (summit in summits) {
        if (dist[summit] < answerCost) {
            answerCost = dist[summit]
            answerSummit = summit
        }
    }

    return intArrayOf(answerSummit, answerCost)
}