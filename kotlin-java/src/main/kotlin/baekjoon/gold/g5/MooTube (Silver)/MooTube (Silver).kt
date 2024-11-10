package baekjoon.gold.g5.`MooTube (Silver)`

import java.util.LinkedList
import java.util.Queue

data class Edge(val to: Int, val weight: Int)

lateinit var graph: Array<MutableList<Edge>>
var n = 0
var q = 0

fun main() = with(System.`in`.bufferedReader()) {
    val nq = readLine().split(" ").map { it.toInt() }
    n = nq[0]
    q = nq[1]

    graph = Array(n) { mutableListOf() }
    repeat(n - 1) {
        val (p, q, r) = readLine().split(" ").map { it.toInt() }
        graph[p - 1].add(Edge(q - 1, r))
        graph[q - 1].add(Edge(p - 1, r))
    }

    repeat(q) {
        val (k, v) = readLine().split(" ").map { it.toInt() }
        println(bfs(k, v - 1))
    }
}

fun bfs(k: Int, v: Int): Int {
    var cnt = 0
    val visited = BooleanArray(n).apply { this[v] = true }
    val queue = LinkedList<Int>() as Queue<Int>
    queue.add(v)

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        graph[cur].forEach { (to, weight) ->
            if (visited[to] || weight < k) return@forEach
            cnt++
            visited[to] = true
            queue.add(to)
        }
    }

    return cnt
}
