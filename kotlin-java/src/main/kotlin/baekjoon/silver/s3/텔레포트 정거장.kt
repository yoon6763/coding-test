package baekjoon.silver.s3

import java.util.ArrayList
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val q = LinkedList<Int>() as Queue<Int>
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val (s, e) = readLine().split(" ").map { it.toInt() }
    val visited = IntArray(n + 1)
    val graph = Array(n + 1) { arrayListOf(it - 1, it + 1) }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (from, to) = st.nextToken().toInt() to st.nextToken().toInt()
        graph[from].add(to)
        graph[to].add(from)
    }

    q.offer(s)
    visited[s] = 1

    while (q.isNotEmpty()) {
        val cur = q.poll()
        graph[cur].forEach { next ->
            if (next !in 1..n || visited[next] != 0) return@forEach
            if (next == e) {
                println(visited[cur])
                return
            }
            visited[next] = visited[cur] + 1
            q.offer(next)
        }
    }
}