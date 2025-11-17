package baekjoon.gold.g4.`두 로봇`

import java.util.LinkedList
import java.util.Queue

data class Node(val next: Int, val distance: Int, val maxCost: Int)
data class Edge(val next: Int, val cost: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, r1, r2) = readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(n + 1)
    val graph = Array(n + 1) { ArrayList<Edge>() }
    repeat(n - 1) {
        val (v1, v2, cost) = readLine().split(" ").map { it.toInt() }
        graph[v1].add(Edge(v2, cost))
        graph[v2].add(Edge(v1, cost))
    }

    val q = LinkedList<Node>() as Queue<Node>
    q.add(Node(r1, 0, 0))
    visited[r1] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (cur.next == r2) {
            println(cur.distance - cur.maxCost)
            return
        }

        graph[cur.next].forEach { (next, cost) ->
            if (visited[next]) return@forEach
            visited[next] = true
            q.add(Node(next, cur.distance + cost, cur.maxCost.coerceAtLeast(cost)))
        }
    }
}