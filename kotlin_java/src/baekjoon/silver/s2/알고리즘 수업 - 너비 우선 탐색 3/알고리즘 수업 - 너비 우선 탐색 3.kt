package baekjoon.silver.s2.`알고리즘 수업 - 너비 우선 탐색 3`

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val (n, m, r) = Array(3) { st.nextToken().toInt() }

    val connect = Array(n + 1) { ArrayList<Int>() }
    val visited = Array(n + 1) { -1 }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = Array(2) { st.nextToken().toInt() }
        connect[v1].add(v2)
        connect[v2].add(v1)
    }

    visited[r] = 0

    val q = LinkedList<Int>() as Queue<Int>
    q.offer(r)

    while (q.isNotEmpty()) {
        val target = q.poll()
        connect[target].forEach { next ->
            if (visited[next] == -1) {
                visited[next] = visited[target] + 1
                q.offer(next)
            }
        }
    }
    val sb = StringBuilder()
    repeat(n) { sb.append(visited[it + 1]).append("\n") }
    print(sb)
}