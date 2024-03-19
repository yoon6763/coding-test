package baekjoon.silver.s2

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    val (start, end) = readLine().split(" ").map { it.toInt() }
    if (start == end) return println(0)

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { ArrayList<Int>() }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val visited = IntArray(n + 1)
    val q = LinkedList<Int>() as Queue<Int>
    q.offer(start)
    visited[start] = 1

    while (q.isNotEmpty()) {
        val cur = q.poll()

        graph[cur].forEach { next ->
            if (visited[next] != 0) return@forEach

            if (next == end) {
                println(visited[cur])
                return
            }

            visited[next] = visited[cur] + 1
            q.offer(next)
        }
    }

    println(-1)
}