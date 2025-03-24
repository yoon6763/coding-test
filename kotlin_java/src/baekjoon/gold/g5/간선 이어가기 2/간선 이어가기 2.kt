package baekjoon.gold.g5.`간선 이어가기 2`

import java.util.*

data class Edge(val to: Int, val weight: Int)

lateinit var graph: Array<ArrayList<Edge>>

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { ArrayList() }

    val connectionInfos = Array(m) { readLine() }
    val (s, e) = readLine().split(" ").map { it.toInt() }

    repeat(m) {
        val st = StringTokenizer(connectionInfos[it])
        val (a, b, c) = Array(3) { st.nextToken().toInt() }
        graph[a].add(Edge(b, c))
        graph[b].add(Edge(a, c))
    }

    println(dijkstra(n, s, e))
}

fun dijkstra(n: Int, start: Int, end: Int): Int {
    val distance = IntArray(n + 1) { Int.MAX_VALUE }
    distance[start] = 0

    val pq = PriorityQueue<Edge> { o1, o2 -> o1.weight - o2.weight }
    pq.offer(Edge(start, 0))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (cur.weight > distance[cur.to]) continue

        graph[cur.to].forEach { next ->
            val nextDistance = distance[cur.to] + next.weight
            if (nextDistance < distance[next.to]) {
                distance[next.to] = nextDistance
                pq.offer(Edge(next.to, nextDistance))
            }
        }
    }

    return distance[end]
}