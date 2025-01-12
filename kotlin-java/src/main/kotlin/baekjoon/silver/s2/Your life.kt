package baekjoon.silver.s2

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val path = Array(n + 1) { ArrayList<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        path[a].add(b)
    }

    val visited = IntArray(n + 1)
    visited[1] = 1
    val q = LinkedList<Int>() as Queue<Int>
    q.add(1)

    while (q.isNotEmpty()) {
        val cur = q.poll()

        path[cur].forEach { next ->
            if (visited[next] != 0) return@forEach
            if (next == n) {
                println(visited[cur])
                return
            }
            visited[next] = visited[cur] + 1
            q.add(next)
        }
    }

    println(-1)
}