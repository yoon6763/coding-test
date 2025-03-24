package baekjoon.silver.s1

import java.util.LinkedList
import java.util.Queue

fun main() {
    val (powerA, powerB, start, end) = readln().split(" ").map { it.toInt() }

    val q = LinkedList<Int>() as Queue<Int>
    val n = 100000
    val visited = IntArray(n + 1)

    q.offer(start)
    visited[start] = 1

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (next in listOf(
            cur * powerA, cur * powerB,
            cur - 1, cur + 1,
            cur - powerA, cur - powerB,
            cur + powerA, cur + powerB
        )) {
            if (next !in 0..n || visited[next] != 0) continue

            if (next == end) {
                println(visited[cur])
                return
            }

            visited[next] = visited[cur] + 1
            q.offer(next)
        }
    }
}