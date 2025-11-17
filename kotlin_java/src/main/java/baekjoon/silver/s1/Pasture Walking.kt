package baekjoon.silver.s1

import java.util.*

fun main() {
    data class Edge(val to: Int, val cost: Int)

    val (n, q) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Edge>() }

    repeat(n - 1) {
        val (a, b, l) = readln().split(" ").map { it.toInt() }
        graph[a].add(Edge(b, l))
        graph[b].add(Edge(a, l))
    }

    fun bfs(start: Int, end: Int): Int {
        val dist = IntArray(n + 1) { -1 }
        val q = ArrayDeque<Int>()
        dist[start] = 0
        q.add(start)

        while (q.isNotEmpty()) {
            val cur = q.poll()
            if (cur == end) break
            graph[cur].forEach { next ->
                if (dist[next.to] != -1) return@forEach
                dist[next.to] = dist[cur] + next.cost
                q.add(next.to)
            }
        }
        return dist[end]
    }

    val sb = StringBuilder()

    repeat(q) {
        val (p1, p2) = readln().split(" ").map { it.toInt() }
        sb.appendLine(bfs(p1, p2))
    }

    print(sb)
}