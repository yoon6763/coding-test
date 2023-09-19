package baekjoon.gold.g5.택배배송

import java.util.*

data class Edge(val to: Int, val cost: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Edge>() }

    repeat(m) {
        val (s, e, c) = readLine().split(" ").map { it.toInt() }
        graph[s].add(Edge(e, c))
        graph[e].add(Edge(s, c))
    }

    println(dijkstra(n, graph, 1)[n])
}


fun dijkstra(n: Int, graph: Array<MutableList<Edge>>, start: Int): IntArray {
    val distance = IntArray(n + 1) { Int.MAX_VALUE }

    val pq = PriorityQueue<Edge>(compareBy { it.cost })
    pq.offer(Edge(start, 0))
    distance[start] = 0

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        graph[cur.to].forEach { next ->
            val nCost = next.cost + distance[cur.to]

            if (nCost < distance[next.to]) {
                distance[next.to] = nCost
                pq.offer(Edge(next.to, nCost))
            }
        }
    }

    return distance
}