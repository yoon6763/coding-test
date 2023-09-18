package baekjoon.silver.s2

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val q = LinkedList<Int>() as Queue<Int>

    q.offer(0)
    val visited = IntArray(n) { -1 }
    visited[0] = 0

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until arr[cur]) {
            val next = cur + i + 1
            if (next >= n) break
            if (visited[next] != -1) continue
            visited[next] = visited[cur] + 1
            q.offer(next)
        }
    }

    println(visited[n - 1])
}