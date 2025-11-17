package baekjoon.silver.s2.`알고리즘 수업 - 너비 우선 탐색 4`

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val (n, m, start) = Array(3) { st.nextToken().toInt() }

    val connect = Array(n + 1) { ArrayList<Int>() }
    val sequence = Array(n + 1) { 0 }
    var sequenceIdx = 2
    val depth = Array(n + 1) { -1 }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (v1, v2) = Array(2) { st.nextToken().toInt() }
        connect[v1].add(v2)
        connect[v2].add(v1)
    }
    connect.forEach { it.sort() }

    val q: Queue<Int> = LinkedList<Int>()
    q.offer(start)
    sequence[start] = 1
    depth[start] = 0

    while (q.isNotEmpty()) {
        val target = q.poll()
        connect[target].forEach { next ->
            if (depth[next] == -1) {
                sequence[next] = sequenceIdx++
                depth[next] = depth[target] + 1
                q.offer(next)
            }
        }
    }

    var sum = 0L
    for (i in 1..n) sum += depth[i].toLong() * sequence[i].toLong()
    println(sum)
}