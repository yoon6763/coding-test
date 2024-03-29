package baekjoon.silver.s2.`알고리즘 수업 - 너비 우선 탐색 1`

import java.util.*

fun main() {
    val (n, m, start) = readln().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    graph.forEach { it.sort() }

    val visited = IntArray(n + 1)

    val q = LinkedList<Int>() as Queue<Int>
    q.add(start)
    visited[start] = 1
    var idx = 2

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in graph[target]) {
            if (visited[i] == 0) {
                q.add(i)
                visited[i] = idx++
            }
        }
    }

    println(visited.joinToString("\n").substring(2))
}