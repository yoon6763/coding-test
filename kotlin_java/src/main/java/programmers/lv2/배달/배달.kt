package programmers.lv2.배달

import java.util.PriorityQueue

data class Edge(val to: Int, val cost: Int)

fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
    val pq = PriorityQueue<Edge>(compareBy { it.cost })

    val graph = Array(N + 1) { mutableListOf<Edge>() }
    road.forEach {
        graph[it[0]].add(Edge(it[1], it[2]))
        graph[it[1]].add(Edge(it[0], it[2]))
    }

    val distance = IntArray(N + 1) { Int.MAX_VALUE }

    pq.add(Edge(1, 0))
    distance[1] = 0

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        graph[cur.to].forEach { next ->
            val nCost = distance[cur.to] + next.cost
            if (nCost < distance[next.to]) {
                distance[next.to] = nCost
                pq.offer(Edge(next.to, nCost))
            }
        }
    }
    return distance.count { it <= k }
}