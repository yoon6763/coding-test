package baekjoon.silver.s1

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().trim().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { arrayListOf<Int>() }
    repeat(m) {
        val (a, b) = readLine().trim().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val (a, b) = readLine().trim().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)

        val visited = IntArray(n + 1) { -1 }
        val q = LinkedList<Int>() as Queue<Int>
        q.add(1)
        visited[1] = 0

        while (q.isNotEmpty()) {
            val cur = q.poll()
            graph[cur].forEach { next ->
                if (visited[next] != -1) return@forEach
                visited[next] = visited[cur] + 1
                q.add(next)
            }
        }

        sb.appendLine(visited.slice(1..n).joinToString(" "))
    }

    print(sb)
}