package baekjoon.gold.g4.최단경로

import java.util.PriorityQueue
import java.util.StringTokenizer

data class Edge(val to: Int, val cost: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (v, e) = readLine().split(" ").map { it.toInt() }
    val start = readLine().toInt()

    val graph = Array(v + 1) { ArrayList<Edge>() }
    repeat(e) {
        val st = StringTokenizer(readLine())
        val (v1, v2, cost) = List(3) { st.nextToken().toInt() }
        graph[v1].add(Edge(v2, cost))
    }

    val distance = dijkstra(v, start, graph)
    val sb = StringBuilder()
    for (i in 1..v) {
        sb.appendLine(if (distance[i] == 987654321) "INF" else distance[i])
    }
    print(sb)
}

fun dijkstra(v: Int, start: Int, graph: Array<ArrayList<Edge>>): IntArray {
    val pq = PriorityQueue<Edge>(compareBy { it.cost })
    val distance = IntArray(v + 1) { 987654321 }
    distance[start] = 0
    pq.offer(Edge(start, 0))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (cur.cost > distance[cur.to]) continue

        graph[cur.to].forEach { next ->
            val nCost = distance[cur.to] + next.cost

            if (nCost < distance[next.to]) {
                distance[next.to] = nCost
                pq.offer(Edge(next.to, nCost))
            }
        }
    }

    return distance
}
